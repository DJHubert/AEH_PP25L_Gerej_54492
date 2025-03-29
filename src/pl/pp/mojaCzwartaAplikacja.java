import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Podaj dolny limit (liczba całkowita): ");
            int dolnyLimit = scanner.nextInt();

            System.out.println("Podaj górny limit (liczba całkowita): ");
            int górnyLimit = scanner.nextInt();

            if (górnyLimit <= dolnyLimit) {
                System.out.println("Górny limit musi być większy od dolnego. Program kończy działanie.");
                break;
            }

            int sumaKwadratów = 0;
            for (int i = dolnyLimit; i <= górnyLimit; i++) {
                sumaKwadratów += i * i;
            }

            System.out.println("Suma kwadratów liczb od " + dolnyLimit + " do " + górnyLimit + " wynosi: " + sumaKwadratów);
        }


        while (true) {
            System.out.println("\nWybierz opcję kalkulatora:");
            System.out.println("1 - Dodawanie");
            System.out.println("2 - Odejmowanie");
            System.out.println("3 - Mnożenie");
            System.out.println("4 - Dzielenie");
            System.out.println("5 - Zakończ");

            int opcja = scanner.nextInt();

            if (opcja == 5) {
                System.out.println("Koniec programu.");
                break;
            }

            if (opcja < 1 || opcja > 4) {
                System.out.println("Nieprawidłowa opcja! Spróbuj ponownie.");
                continue;
            }

            System.out.println("Podaj pierwszą liczbę: ");
            double liczba1 = scanner.nextDouble();

            System.out.println("Podaj drugą liczbę: ");
            double liczba2 = scanner.nextDouble();

            double wynik = 0;

            switch (opcja) {
                case 1:
                    wynik = liczba1 + liczba2;
                    System.out.println("Wynik dodawania: " + wynik);
                    break;
                case 2:
                    wynik = liczba1 - liczba2;
                    System.out.println("Wynik odejmowania: " + wynik);
                    break;
                case 3:
                    wynik = liczba1 * liczba2;
                    System.out.println("Wynik mnożenia: " + wynik);
                    break;
                case 4:
                    if (liczba2 == 0) {
                        System.out.println("Błąd: Nie można dzielić przez zero.");
                    } else {
                        wynik = liczba1 / liczba2;
                        System.out.println("Wynik dzielenia: " + wynik);
                    }
                    break;
            }
        }

        scanner.close();
    }
}















