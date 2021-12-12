package project;

import java.util.ArrayList;

public class RSA {

    public void encrypt(long numP, long numE, long numN){
        AlgorithmsLib lib = new AlgorithmsLib();
        long result = lib.fastExponentiationAlgorithm(numP,numE,numN);
        System.out.println("RSA encrypt result= "+result);
    }

    public long findDecryptionKey(long numE, long numD){
        //find factors of numD
        AlgorithmsLib lib = new AlgorithmsLib();
        System.out.println("find factors of numD："+numD);
        lib.primeFactors(numD);

        //find inverse of numE in phi(numD);
        System.out.println("find inverse of "+numE+" in phi("+numD+");");
        long phiD = lib.computePhiNumber(numD);
        System.out.println("phi("+numD+")="+phiD);
        long decryptionKey = lib.computeInverse(numE,phiD);
        System.out.println("Decryption key ="+decryptionKey);
        return decryptionKey;
    }

    public void decryptCiphertext(long numC, long numE, long numD){
        long decryptionKey = findDecryptionKey(numE,numD);
        AlgorithmsLib lib = new AlgorithmsLib();
        ArrayList<Long> primeFactors = lib.primeFactors(numD);

        long phi = (primeFactors.get(0)-1)*(primeFactors.get(1)-1);
        System.out.println("phi ="+phi);
        System.out.println("\nCompute c^e mod (d):");
        System.out.println(numC+","+decryptionKey+","+numD);
        long result = lib.fastExponentiationAlgorithm(numC,decryptionKey,numD);
        System.out.println("RSA decrypt result= "+result);
    }
}
