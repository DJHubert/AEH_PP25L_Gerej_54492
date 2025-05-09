public class mojaDziewiataAplikacja {
    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn();

        magazyn.dodajTowar(3000);
        magazyn.usunTowar(1000);
        magazyn.dodajTowar(2500);
        magazyn.sprawdzZajetosc();
        magazyn.aktualizujKontakt("owner@magazyn.pl", "+48 123 456 789");
        magazyn.dodajTowar(1000);
    }
}

class Magazyn {
    private int numerMagazynu;
    private int dostepnaPrzestrzen;
    private int zajetaPrzestrzen;
    private String wlasciciel;
    private String email;
    private String numerTelefonu;

    public Magazyn() {
        this.numerMagazynu = 1;
        this.dostepnaPrzestrzen = 5000;
        this.zajetaPrzestrzen = 0;
        this.wlasciciel = "Domyślny Właściciel";
        this.email = "default@magazyn.pl";
        this.numerTelefonu = "+48 000 000 000";
    }

    public int getNumerMagazynu() {
        return numerMagazynu;
    }

    public void setNumerMagazynu(int numerMagazynu) {
        this.numerMagazynu = numerMagazynu;
    }

    public int getDostepnaPrzestrzen() {
        return dostepnaPrzestrzen;
    }

    public void setDostepnaPrzestrzen(int dostepnaPrzestrzen) {
        this.dostepnaPrzestrzen = dostepnaPrzestrzen;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public void dodajTowar(int ilosc) {
        if (ilosc <= (dostepnaPrzestrzen - zajetaPrzestrzen)) {
            zajetaPrzestrzen += ilosc;
            System.out.println("Dodano " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + (dostepnaPrzestrzen - zajetaPrzestrzen) + " jednostek.");
        } else {
            System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " + (dostepnaPrzestrzen - zajetaPrzestrzen) + " jednostek.");
        }
    }

    public void usunTowar(int ilosc) {
        if (ilosc <= zajetaPrzestrzen) {
            zajetaPrzestrzen -= ilosc;
            System.out.println("Usunięto " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + (dostepnaPrzestrzen - zajetaPrzestrzen) + " jednostek.");
        } else {
            System.out.println("Za mało towaru w magazynie. Zajęta przestrzeń: " + zajetaPrzestrzen + " jednostek.");
        }
    }

    public void sprawdzZajetosc() {
        System.out.println("Zajęta przestrzeń magazynowa: " + zajetaPrzestrzen + " jednostek.");
        System.out.println("Dostępna przestrzeń magazynowa: " + (dostepnaPrzestrzen - zajetaPrzestrzen) + " jednostek.");
    }

    public void aktualizujKontakt(String nowyEmail, String nowyNumerTelefonu) {
        this.email = nowyEmail;
        this.numerTelefonu = nowyNumerTelefonu;
        System.out.println("Zaktualizowano dane kontaktowe właściciela.");
        System.out.println("Nowy email: " + this.email);
        System.out.println("Nowy numer telefonu: " + this.numerTelefonu);
    }
}
