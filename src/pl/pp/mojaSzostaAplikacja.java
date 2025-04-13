package pl.pp;

public class mojaSzostaAplikacja {

    public static void main(String[] args) {
        int N = 20;

        System.out.println("Obliczanie silni liczby " + N + " metodą iteracyjną:");
        long startTimeIter = System.nanoTime();
        long resultIter = factorialIterative(N);
        long endTimeIter = System.nanoTime();
        System.out.println("Wynik (iteracyjnie): " + resultIter);
        System.out.println("Czas wykonania (iteracyjnie): " + (endTimeIter - startTimeIter) + " ns");

        System.out.println("\nObliczanie silni liczby " + N + " metodą rekurencyjną:");
        long startTimeRec = System.nanoTime();
        long resultRec = factorialRecursive(N);
        long endTimeRec = System.nanoTime();
        System.out.println("Wynik (rekurencyjnie): " + resultRec);
        System.out.println("Czas wykonania (rekurencyjnie): " + (endTimeRec - startTimeRec) + " ns");
    }

    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }
}



