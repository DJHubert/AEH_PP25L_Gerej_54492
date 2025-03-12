package pl.pp;

import java.util.Scanner;

public class mojaDrugaAplikacja {
    public static void main(String[] args) {

        int x;

        x = 10;

        int dwukrotnosc = 2 * x;

        int kwadrat = x * x;

        System.out.println("x = " + x);
        System.out.println("Dwukrotność liczby x = " + dwukrotnosc);
        System.out.println("Wartość x do kwadratu = " + kwadrat);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj swój wiek w latach: ");
        int wiekLata = scanner.nextInt();


        long sekundyWroku = 365 * 24 * 60 * 60;
        long wiekSekundy = (long) wiekLata * sekundyWroku;

        System.out.println("Twój wiek w sekundach wynosi: " + wiekSekundy);

        scanner.close();

    }


}


