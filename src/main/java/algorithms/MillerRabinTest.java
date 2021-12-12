package algorithms;

import java.util.Random;

public class MillerRabinTest {
    public boolean millerRabinTest(long numN)
    {
        if(numN == 2|| numN ==3){
            return true;
        }
        if(numN <=1 || numN ==4)
        {
            return false;
        }

        for(int i=0;i<4;i++)
        {
            if(isPrime((numN))==false)
            {
                System.out.println(numN+" is not prime");
                return false;
            }
        }
        System.out.println(numN+" is prime");
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
        if(numB ==1){
            return true;
        }
        for(long i=0;i<numK;i++)
        {
            if(numB ==(numN-1))
            {
                return true;
            }else{
                numB = (numB*numB)%numN;
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



    //calculate(x^y)%p
    public long multiPower(long numX, long numY, long numP)
    {
        long result = 1;
        numX = numX%numP;
        while(numY>0)
        {
            if((numY&1)==1)
            {
                result = (result * numX)%numP;
            }
            numY = numY >> 1; //numY = numY/2
            numX = (numX * numX) %numP;
        }
        return result;
    }
}
