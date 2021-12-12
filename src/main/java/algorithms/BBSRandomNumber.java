package algorithms;

import java.util.Random;

public class BBSRandomNumber {
    public long randomNumberBSS(){
        long numP = getRandomPrime();
        long numQ = getRandomPrime();
        long numN = numP*numQ;
        ComputePhi compute = new ComputePhi();
//        System.out.println("numN: "+numN);
        long[] seedChosen = new long[13];
        for(int i=0;i< seedChosen.length;i++)
        {
            ExtendedEuclideanAlgorithm test = new ExtendedEuclideanAlgorithm();
            Random currR = new Random();
            long currNum;
            do{
                currNum = currR.nextLong(numN-1);
            }while(test.booleanExtendedEuclideanAlgorithm((int) numN, (int) currNum, 1, 0, 0, 1) == false);
            seedChosen[i] = currNum;
        }

        //create bits random number
        long bitNum =0;
        for(int i=0;i< seedChosen.length-1;i++)
        {
            int curr =(int) seedChosen[i]%2;
//            System.out.println("\nori: "+Long.toBinaryString(bit30));
            bitNum = bitNum<<1;
            bitNum+=curr;
//            System.out.println("new: "+Long.toBinaryString(bit30));

        }
        if(bitNum<0)
        {
            bitNum = bitNum*(-1);
        }
        return bitNum;
    }

    public long getRandomPrime(){

        long randomNum = getRandomNum();
        MillerRabinTest test = new MillerRabinTest();
        while( is3Mod4(randomNum)==false || test.millerRabinTest(randomNum)==false)
        {
            randomNum = getRandomNum();
        }
        return randomNum;
    }

    public boolean is3Mod4(long num){
        long result = num%4;
        if(result == 3)
        {
            return true;
        }else{
            return false;
        }
    }

    private long getRandomNum(){
        int randomDigits = (int) (3+Math.random()*(5-3));
//        System.out.println("random digits:"+randomDigits);
        long digits =1;
        for(int i=0; i< randomDigits;i++){
            digits*=10;
        }
        return (long) ((Math.random()*9+1)*digits);
    }
}
