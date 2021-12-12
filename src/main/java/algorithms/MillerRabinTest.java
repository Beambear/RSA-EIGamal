package algorithms;

import java.util.Random;

public class MillerRabinTest {
    public boolean millerRabinTest(long numN)
    {
        //check special conditions
        if(numN == 2|| numN ==3){
            return true;
        }
        if(numN <=1 || numN ==4)
        {
            return false;
        }

        //run test
        for(int i=0;i<4;i++)
        {
            if(isPrime((numN))==false)
            {
//                System.out.println(numN+" is not prime");
                return false;
            }
        }
//        System.out.println(numN+" is prime");
        return true;
    }

    public boolean isPrime(long numN)
    {
        long[] array = longToIndex(numN -1);
        long numK = array[0];
        long numM = array[1];
        Random numR = new Random();
        long numA =0;
        while(numA<2){
            numA = numR.nextLong(numN-1 );
        }
        FastExponentiationAlgorithm doIt = new FastExponentiationAlgorithm();
        long numB = doIt.fastExponentiation(numA,numM,numN);
//        long numB = powMRT(numA,numM,numN);
        if(numB ==1){   //if numB=1modN
            return true;
        }
        for(long i=0;i<numK;i++)
        {
            if(numB ==(numN-1)) // if B RP to numN
            {
                return true;
            }else{
                numB = (numB*numB)%numN; //go next
            }
        }
        return false;
    }

    public long[] longToIndex(long numN)
    {
        long[] array = new long[2];
        long numK =0;
        long numX;
        //stop when numN = odd
        do{
            numK++;
            numN >>= 1;
            numX = numN & 1;
        }while(numX ==0);

        array[0] =numK;
        array[1] =numN;
        return array;
    }

    //The FastExponentiation Algorithm will cause error when calculate large number in MillerRabinTest
    //compute a^b%m
    private long powMRT(long x, long y, long p){
        long res = 1; // Initialize result

        x = x % p; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
            {
                res = (res * x) % p;

            }

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
}
