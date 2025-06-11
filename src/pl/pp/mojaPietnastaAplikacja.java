import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class mojaPietnastaAplikacja {

    interface TypPaliwa {
        String getTypPaliwa();
    }

    static class Diesel implements TypPaliwa {
        public String getTypPaliwa() { return "Diesel"; }
    }

    static class Benzyna implements TypPaliwa {
        public String getTypPaliwa() { return "Benzyna"; }
    }

    static class Elektryk implements TypPaliwa {
        public String getTypPaliwa() { return "Elektryk"; }
    }

    static abstract class Pojazd {
        protected String nrRejestracyjny, numerVin, kolor;
        protected double cena, spalanie, poziomPaliwa;
        protected int przebieg;

        public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie,
                      double poziomPaliwa, int przebieg) {
            this.nrRejestracyjny = nrRejestracyjny;
            this.numerVin = numerVin;
            this.kolor = kolor;
            this.cena = cena;
            this.spalanie = spalanie;
            this.poziomPaliwa = poziomPaliwa;
            this.przebieg = przebieg;
        }

        public void prowadz(int km) {
            double zuzytePaliwo = (km / 100.0) * spalanie;
            if (poziomPaliwa >= zuzytePaliwo) {
                poziomPaliwa -= zuzytePaliwo;
                przebieg += km;
                System.out.println("Przejechano " + km + " km. Zużyto " + zuzytePaliwo + " l paliwa.");
            } else {
                System.out.println("Za mało paliwa, nie można jechać!");
            }
        }

        public void zatankuj(double litry) {
            poziomPaliwa += litry;
            System.out.println("Zatankowano " + litry + " l. Nowy poziom paliwa: " + poziomPaliwa);
        }

        public abstract void wypiszInformacje();
    }

    static class Osobowe extends Pojazd {
        private int liczbaDrzwi;
        private TypPaliwa typPaliwa;

        public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie,
                       double poziomPaliwa, int przebieg, int liczbaDrzwi, TypPaliwa typPaliwa) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
            this.liczbaDrzwi = liczbaDrzwi;
            this.typPaliwa = typPaliwa;
        }

        @Override
        public void wypiszInformacje() {
            System.out.println("Samochód osobowy [" + nrRejestracyjny + "] | Drzwi: " + liczbaDrzwi +
                    " | Paliwo: " + typPaliwa.getTypPaliwa());
        }
    }

    static class Klient {
        private String imie;
        private String nazwisko;
        private String id;

        public Klient(String imie, String nazwisko, String id) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.id = id;
        }

        public String getPelnaNazwa() {
            return imie + " " + nazwisko;
        }

        public String getId() {
            return id;
        }
    }

    static class Wypozyczenie {
        private Klient klient;
        private Pojazd pojazd;
        private LocalDateTime dataWypozyczenia;
        private LocalDateTime dataZwrotu;

        public Wypozyczenie(Klient klient, Pojazd pojazd) {
            this.klient = klient;
            this.pojazd = pojazd;
            this.dataWypozyczenia = LocalDateTime.now();
        }

        public void zakonczWypozyczenie() {
            this.dataZwrotu = LocalDateTime.now();
        }

        public boolean aktywne() {
            return dataZwrotu == null;
        }

        public void wypiszInformacje() {
            System.out.println("Wypożyczenie: " + klient.getPelnaNazwa() + " -> " + pojazd.nrRejestracyjny +
                    " od " + dataWypozyczenia +
                    (dataZwrotu != null ? " do " + dataZwrotu : " [AKTYWNE]"));
        }

        public Pojazd getPojazd() {
            return pojazd;
        }
    }

    static class SystemWypozyczalni {
        private List<Pojazd> pojazdy = new ArrayList<>();
        private List<Wypozyczenie> wypozyczenia = new ArrayList<>();

        public void dodajPojazd(Pojazd p) {
            pojazdy.add(p);
        }

        public void wypiszDostepnePojazdy() {
            System.out.println("Dostępne pojazdy:");
            for (Pojazd p : pojazdy) {
                if (!czyWypozyczony(p)) {
                    p.wypiszInformacje();
                }
            }
        }

        public boolean czyWypozyczony(Pojazd p) {
            return wypozyczenia.stream().anyMatch(w -> w.getPojazd() == p && w.aktywne());
        }

        public void wypozyczPojazd(Klient klient, String nrRejestracyjny) {
            for (Pojazd p : pojazdy) {
                if (p.nrRejestracyjny.equals(nrRejestracyjny) && !czyWypozyczony(p)) {
                    wypozyczenia.add(new Wypozyczenie(klient, p));
                    System.out.println("Wypożyczono pojazd " + nrRejestracyjny + " klientowi " + klient.getPelnaNazwa());
                    return;
                }
            }
            System.out.println("Nie można wypożyczyć pojazdu: nie znaleziono lub już wypożyczony.");
        }

        public void zwrocPojazd(String nrRejestracyjny) {
            for (Wypozyczenie w : wypozyczenia) {
                if (w.getPojazd().nrRejestracyjny.equals(nrRejestracyjny) && w.aktywne()) {
                    w.zakonczWypozyczenie();
                    System.out.println("Zwrócono pojazd: " + nrRejestracyjny);
                    return;
                }
            }
            System.out.println("Nie znaleziono aktywnego wypożyczenia dla tego pojazdu.");
        }

        public void wypiszWszystkieWypozyczenia() {
            for (Wypozyczenie w : wypozyczenia) {
                w.wypiszInformacje();
            }
        }
    }

    public static void main(String[] args) {
        TypPaliwa benzyna = new Benzyna();
        TypPaliwa diesel = new Diesel();

        Pojazd auto1 = new Osobowe("DW1234", "VIN001", "Czerwony", 50000, 6.5, 30, 150000, 5, benzyna);
        Pojazd auto2 = new Osobowe("KR5678", "VIN002", "Niebieski", 60000, 7.0, 40, 100000, 5, diesel);

        Klient klient1 = new Klient("Jan", "Kowalski", "ID001");
        Klient klient2 = new Klient("Anna", "Nowak", "ID002");

        SystemWypozyczalni wypozyczalnia = new SystemWypozyczalni();
        wypozyczalnia.dodajPojazd(auto1);
        wypozyczalnia.dodajPojazd(auto2);

        System.out.println("\n=== DOSTĘPNE POJAZDY ===");
        wypozyczalnia.wypiszDostepnePojazdy();

        System.out.println("\n=== WYPOŻYCZANIE POJAZDÓW ===");
        wypozyczalnia.wypozyczPojazd(klient1, "DW1234");
        wypozyczalnia.wypozyczPojazd(klient2, "KR5678");

        System.out.println("\n=== DOSTĘPNE POJAZDY PO WYPOŻYCZENIU ===");
        wypozyczalnia.wypiszDostepnePojazdy();

        System.out.println("\n=== ZWRACANIE POJAZDU ===");
        wypozyczalnia.zwrocPojazd("DW1234");

        System.out.println("\n=== HISTORIA WYPOŻYCZEŃ ===");
        wypozyczalnia.wypiszWszystkieWypozyczenia();
    }
}
