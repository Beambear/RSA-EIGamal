package algorithms;
//1.4 Factor number into primes.
//寻找质因数
// A function to print all prime factors of a given number n

import java.util.ArrayList;

public class PrimeFactor {
    public ArrayList<Long> primeFactors(long n)
    {
        ArrayList<Long> primeFactorList = new ArrayList<Long>();
        // Print the number of 2s that divide n
        while (n%2==0)
        {
            primeFactorList.add((long) 2);
//            System.out.print(2 + " ");
            n /= 2;
        }
        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                primeFactorList.add((long) i);
//                System.out.print(i + " ");
                n /= i;
            }
        }
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2){
            primeFactorList.add(n);
//            System.out.print(n);
        }
        return primeFactorList;
    }
}