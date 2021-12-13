package project;

import java.util.Random;

public class EIGamal {
    //C1 =899447728, C2 = 646540783
    //generate key set for EIGamal
    //
    public long[] generateKeys(){
        //get a large prime number
        long numP = randomPrimeWDoubleCheck();

        //get a primitive root numAlpha
        AlgorithmsLib lib = new AlgorithmsLib();
        Random currR = new Random();
        long numAlpha;
        do{
            numAlpha = currR.nextLong(numP-1);
        }while(lib.isPrimitiveRoot(numAlpha,numP) == false);

        //get random numD as secret key. where 2<= numD <= numP-2
        long numD = currR.nextLong((numP-2)-2);

        //compute pubKeyY. where Y = (numAlpha ^ numD) mod (numP)
        long pubKey = lib.fastExponentiationAlgorithm(numAlpha,numD,numP);

        //return key set
        long[] keySet = {numP,numAlpha,pubKey};
        System.out.println("Public key set:{P: "+numP+", generator: "+numAlpha+", pubKey: "+pubKey+"}");
        System.out.println("Secret Key: {"+numD+"}");
        return keySet;
    }

    //
    //  encrypt plain text (numPtxt) with numP, numAlpha and pubKey
    //  C1= a^K mod P =（numAlpha ^ numK) mod (numP)
    //  C2= (txt*Y)^k mod p =((numPtxt * pubKey) ^ numK） mod (numP)
    //
    public long[] encrypt(long numPtxt, long numP, long numAlpha, long pubKey)
    {
        //get random numK
        Random currR = new Random();
        long numK = currR.nextLong((numP-2)-2);

        // compute C1 / public K
        AlgorithmsLib lib = new AlgorithmsLib();
        long numC1 = lib.fastExponentiationAlgorithm(numAlpha,numK,numP);
        // compute C2 / Cipher
        long numC2 = numPtxt * lib.fastExponentiationAlgorithm(pubKey,numK,numP);

        //return cipher txt
        System.out.println("public K ="+numC1+", Cipher = "+numC2);
        long[] cipherResut ={numC1,numC2};
        return cipherResut;
    }

    //
    //  decrypt cipher text (numC1,numC2) with numD and numP
    //  P=C2/C1^d mod p = C2 * (C1^d)^(-1) mod p
    //
    public void decrypt(long numC1, String numC2, long keyS, long numP){
        //Use extended Euclidean to compute (C1^d)^(-1) first.
        long c2 = Long.valueOf(numC2);
        AlgorithmsLib lib = new AlgorithmsLib();
        long numX = lib.fastExponentiationAlgorithm(numC1,keyS, numP);
        long c1Inv = lib.computeInverse(numX,numP);
        long result = c1Inv * c2 % numP;
        System.out.println(result);
    }


    //
    //sometime the same number while get incorrect answer.
    //like 622, it is checked as prime about 5% chance. So write a double check method.
    //
    private long randomPrimeWDoubleCheck(){
        AlgorithmsLib lib = new AlgorithmsLib();
        long currentNum;
        do{
            currentNum= lib.getBBSPNforEIGamal();
        }while(lib.millerRabinTest(currentNum)==false);
//        System.out.println(currentNum+" result:"+lib.millerRabinTest(currentNum));
        return currentNum;
    }
}
