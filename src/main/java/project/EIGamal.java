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
        System.out.println("Public key set:{P: "+numP+", generator: "+numAlpha+", pubKeyBob: "+pubKey+"}");
        System.out.println("Secret Key: {"+numD+"}");
        return keySet;
    }

    //
    //  encrypt plain text (numPtxt) with numP, numAlpha and pubKey
    //  C1= a^K mod P =（numAlpha ^ numK) mod (numP)
    //  C2= (txt*Y)^k mod p =((numPtxt * pubKey) ^ numK） mod (numP)
    //
    public long[] encrypt(long numPtxt, long numP, long generator, long pubKeyBob)
    {
        //get random numK
        Random currR = new Random();
        long numK = currR.nextLong((numP-2)-2);

        // compute C1 / public K
        AlgorithmsLib lib = new AlgorithmsLib();
        long numC1 = lib.fastExponentiationAlgorithm(generator,numK,numP);
        // compute C2 / Cipher
        long numC2 = numPtxt * lib.fastExponentiationAlgorithm(pubKeyBob,numK,numP);

        //return cipher txt
        System.out.println("publicKeyAlice C1="+numC1+", Cipher C2= "+numC2);
        long[] cipherResut ={numC1,numC2};
        return cipherResut;
    }

    //
    //  decrypt cipher text (numC1,numC2) with numD and numP
    //  P=C2/C1^d mod p = C2 * (C1^d)^(-1) mod p
    //  C1 =publicKeyAlice   C2= Cipher text
    //
    public long decrypt(long numC1, String numC2, String keyS, long numP){
        //Use extended Euclidean to compute (C1^d)^(-1) first.
        long c2 = Long.valueOf(numC2);
        long keySecret = Long.valueOf(keyS);
        AlgorithmsLib lib = new AlgorithmsLib();
        long numX = lib.fastExponentiationAlgorithm(numC1,keySecret, numP);
        long c1Inv = lib.computeInverse(numX,numP);
        long result = c1Inv * c2 % numP;
        System.out.println("decrypt result: "+result);
        return result;
    }

    //
    // known generator, numP, publicKeyBob, publicKeyAlice, cipherTextAlice
    // need to find keySecret to break encrypt
    // 1.compute Alice's k by evaluating the discrete logarithm k=log(a)r in numP, where a=generator, r=publicKeyAlice
    // 2.compute m=t*b^(-k) (mod p),where t =C2 cipher text, b= publicKeyBob
    //
    public long eavesdropDecryptCiphertext(long numP, long generator, long publicKeyAlice, String cipherText, long publicKeyBob){
        //1. compute Alice's K by babyStepGiantStep
        AlgorithmsLib lib = new AlgorithmsLib();
        String keyAlice = String.valueOf(lib.babyStepGiantStep(generator,publicKeyAlice,numP));
        System.out.println("bsgs result: "+keyAlice);
        //2.compute m=t*b^(-k) (mod p)
        long result = decrypt(publicKeyBob, String.valueOf(cipherText), keyAlice,numP);
        return result;
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
