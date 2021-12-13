package algorithms;

public class EratosthenesSieve {
    public void eratosthenseSieve(int num) {
        boolean prime[] = new boolean[num + 1];
        for (int i = 0; i <= num; i++)
            prime[i] = true;

        for (int p = 2; p * p <= num; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= num; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= num; i++) {
            if (prime[i] == true) {
                System.out.print(i + " ");
            }
        }
    }
}
