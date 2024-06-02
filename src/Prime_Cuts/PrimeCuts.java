package Prime_Cuts;

import java.util.*;
import java.io.*;

public class PrimeCuts {

    public static void main(String[] args) throws IOException {
        String filePathIn = "cuts.in";
        Scanner scanner = new Scanner(new File(filePathIn));
        String filePathOut = "cuts.out";
        PrintWriter writer = new PrintWriter(new File(filePathOut));

        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int C = scanner.nextInt();

            List<Integer> primes = getPrimes(N);
            List<Integer> resultPrimes = getCenteredPrimes(primes, C);

            writer.print(N + " " + C + ":");
            for (int prime : resultPrimes) {
                writer.print(" " + prime);
            }
            writer.println();
            writer.println();
        }

        scanner.close();
        writer.close();
    }

    private static List<Integer> getPrimes(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static List<Integer> getCenteredPrimes(List<Integer> primes, int C) {
        int size = primes.size();
        int numToDisplay = (size % 2 == 0) ? 2 * C : 2 * C - 1;

        if (numToDisplay >= size) {
            return primes;
        }

        int center = size / 2;
        int start = center - numToDisplay / 2;
        return primes.subList(start, start + numToDisplay);
    }
}