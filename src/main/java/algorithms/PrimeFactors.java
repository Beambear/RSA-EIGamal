package algorithms;
//Factor a number into primes.
//A function to find all prime factors of a given number n
//寻找质因数

import java.util.ArrayList;

public class PrimeFactors {
    public ArrayList<Long> primeFactors(long n)
    {
        ArrayList<Long> factors = new ArrayList<Long>();
        // Print the number of 2s that divide n
        while (n%2==0)
        {
            factors.add((long)2);
            System.out.print(2 + " ");
            n /= 2;
        }
        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (long i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                factors.add(i);
                System.out.print(i + " ");
                n /= i;
            }
        }
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2){
            factors.add(n);
            System.out.print(n);
        }
        return factors;
    }
}
