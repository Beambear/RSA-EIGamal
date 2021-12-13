package project;

import java.util.ArrayList;
import java.util.Random;

public class RSA {

    //
    //generate key set for RSA
    //
    public long[] generateKeys(){
        //Compute N,L(middle number, not in key),E,D
        AlgorithmsLib lib = new AlgorithmsLib();
        //generate p,q and compute n
        long numP= randomPrimeWDoubleCheck();
        long numQ;
        do{
            numQ = randomPrimeWDoubleCheck();
        }while(lib.isRelativePrime(numP,numQ)==false);
        System.out.println("numP: "+numP+",numQ: "+numQ);
        long numN = numP*numQ;
//        System.out.println("numN: "+numN);

        //get L. L=lcm(p-1,q-1)
        long gcd = lib.findGCD(numP-1,numQ-1);
        long numL = ((numP-1)*(numQ-1))/gcd;
//        System.out.println("numL: "+numL);


        //get E. where 1<E<L and gcd(E,L) =1
        Random currR = new Random();
        long numE;
        do{
            numE = currR.nextLong(numL-1);
        }while(lib.isRelativePrime(numL,numE) == false || numE<2);
//        System.out.println("numE: "+numE);


        //Compute D where 1<D<L. E*D mod L =1;
        long numD;
        numD = lib.computeInverse(numE,numL);
//        System.out.println("numD: "+numD);

        //store keys in arrayE,D,N
        System.out.println("key set {numE:"+numE+", numD:"+numD+", numN:"+numN+"}");
        long[] keys = {numE,numD,numN};
        return keys;
    }

    //
    //  encrypt plain text (numP) with numE and numN
    //  C=(p^e) mod n
    //
    public long encrypt(long txtP, long numE, long numN){
        AlgorithmsLib lib = new AlgorithmsLib();
        long result = lib.fastExponentiationAlgorithm(txtP,numE,numN);
        System.out.println("RSA encrypt result= "+result);
        return result;
    }

    //
    //  decrypt cipher text (numC) with numD and numN
    //  P=(c^d) mod n
    //
    public long decrypt(long numC, long numD, long numN){
        AlgorithmsLib lib = new AlgorithmsLib();
        long result = lib.fastExponentiationAlgorithm(numC,numD,numN);
        System.out.println("RSA decrypt result= "+result);
        return result;
    }

    //
    //  find decryption key with known public key numE and numN
    //
    public long findDecryptionKey(long numE, long numN){
        //find factors of numD
        AlgorithmsLib lib = new AlgorithmsLib();
//        System.out.println("find factors of numD："+numN);
        ArrayList<Long> primeFactors = lib.primeFactors(numN);
        //find inverse of numE in phi(numD);
//        System.out.println("find inverse of "+numE+" in phi("+numN+");");
        long phiN = (primeFactors.get(0)-1)*(primeFactors.get(1)-1);
//        System.out.println("phi("+numN+")="+phiN);
        long decryptionKey = lib.computeInverse(numE,phiN);
        System.out.println("Decryption key ="+decryptionKey+", P="+primeFactors.get(0)+", Q="+primeFactors.get(1));
        return decryptionKey;
    }

    //
    //  evasdrop and decrypt cipher text (numC) by known public key numE and numN
    //
    public long eavesdropDecryptCiphertext(long numC, long numE, long numN){
        long decryptionKey = findDecryptionKey(numE,numN);
        AlgorithmsLib lib = new AlgorithmsLib();
//        System.out.println("phi ="+phi);
//        System.out.println("\nCompute c^e mod (N):");
//        System.out.println(numC+","+decryptionKey+","+numN);
        long result = lib.fastExponentiationAlgorithm(numC,decryptionKey,numN);
        System.out.println("RSA eavesdrop and decrypt result= "+result);
        return result;
    }

    //
    //  evasdrop and decrypt cipher text (numC) by known public key numE and numN
    //
    public long eavesdropDecryptCiphertextForString(Long numC, String numEs, String numNs){
//        long numC = Long.valueOf(numCs);
        long numE = Long.valueOf(numEs);
        long numN = Long.valueOf(numNs);
        long decryptionKey = findDecryptionKey(numE,numN);
        AlgorithmsLib lib = new AlgorithmsLib();
        long result = lib.fastExponentiationAlgorithm(numC,decryptionKey,numN);
        System.out.println("RSA eavesdrop and decrypt result= "+result);
        return result;
    }

    //
    //sometime the same number while get incorrect answer.
    //like 622, about 5% chance it is checked as prime. So write a double check method to ensure that doesn't happen too open
    //
    private long randomPrimeWDoubleCheck(){
        AlgorithmsLib lib = new AlgorithmsLib();
        long currentNum;
        do{
            currentNum= lib.getBBSPrimeNumber();
        }while(lib.millerRabinTest(currentNum)==false);
//        System.out.println(currentNum+" result:"+lib.millerRabinTest(currentNum));
        return currentNum;
    }
}
