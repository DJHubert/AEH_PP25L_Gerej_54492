package pl.pp;

public class mojaPiataAplikacja {
    public static void main(String[] args) {
        rysujZnak('*', 10, 5);
    }

    private static void rysujZnak(char znak, int ilePowtorzen, int ileLinii) {
        for (int i = 0; i < ileLinii; i++) {
            for (int j = 0; j < ilePowtorzen; j++) {
                System.out.print(znak);
            }
            System.out.println();
        }
    }
}


