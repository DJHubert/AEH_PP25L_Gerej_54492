public class mojaCzternastaAplikacja {
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
            System.out.println("Osobowy [" + nrRejestracyjny + "] | Drzwi: " + liczbaDrzwi +
                    " | Paliwo: " + typPaliwa.getTypPaliwa());
        }
    }

    static class Ciezarowka extends Pojazd {
        private double ladownosc;
        private TypPaliwa typPaliwa;

        public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie,
                          double poziomPaliwa, int przebieg, double ladownosc, TypPaliwa typPaliwa) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
            this.ladownosc = ladownosc;
            this.typPaliwa = typPaliwa;
        }

        @Override
        public void wypiszInformacje() {
            System.out.println("Ciężarówka [" + nrRejestracyjny + "] | Ładowność: " + ladownosc +
                    " kg | Paliwo: " + typPaliwa.getTypPaliwa());
        }
    }

    static class Motocykl extends Pojazd {
        private boolean posiadaDostawke;
        private TypPaliwa typPaliwa;

        public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie,
                        double poziomPaliwa, int przebieg, boolean posiadaDostawke, TypPaliwa typPaliwa) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
            this.posiadaDostawke = posiadaDostawke;
            this.typPaliwa = typPaliwa;
        }

        @Override
        public void wypiszInformacje() {
            System.out.println("Motocykl [" + nrRejestracyjny + "] | Dostawka: " + (posiadaDostawke ? "Tak" : "Nie") +
                    " | Paliwo: " + typPaliwa.getTypPaliwa());
        }
    }

    static class SprzetBudowlany extends Pojazd {
        private int przepracowaneGodziny;
        private TypPaliwa typPaliwa;

        public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie,
                               double poziomPaliwa, int przebieg, int przepracowaneGodziny, TypPaliwa typPaliwa) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
            this.przepracowaneGodziny = przepracowaneGodziny;
            this.typPaliwa = typPaliwa;
        }

        @Override
        public void wypiszInformacje() {
            System.out.println("Sprzęt Budowlany [" + nrRejestracyjny + "] | Godziny: " + przepracowaneGodziny +
                    " | Paliwo: " + typPaliwa.getTypPaliwa());
        }
    }

    public static void main(String[] args) {
        TypPaliwa diesel = new Diesel();
        TypPaliwa benzyna = new Benzyna();
        TypPaliwa elektryk = new Elektryk();

        Pojazd auto1 = new Osobowe("DW1234", "VIN001", "Czerwony", 50000, 6.5, 20, 150000, 5, benzyna);
        Pojazd ciezarowka1 = new Ciezarowka("PO2345", "VIN002", "Biały", 120000, 12.0, 50, 300000, 8000, diesel);
        Pojazd moto1 = new Motocykl("KR3456", "VIN003", "Czarny", 15000, 3.0, 5, 20000, true, benzyna);
        Pojazd koparka = new SprzetBudowlany("BU4567", "VIN004", "Żółty", 200000, 20.0, 100, 10000, 500, diesel);

        auto1.wypiszInformacje();
        auto1.prowadz(100);
        auto1.zatankuj(10);

        System.out.println();

        ciezarowka1.wypiszInformacje();
        ciezarowka1.prowadz(200);

        System.out.println();

        moto1.wypiszInformacje();
        moto1.prowadz(50);

        System.out.println();

        koparka.wypiszInformacje();
        koparka.zatankuj(30);
    }
}

