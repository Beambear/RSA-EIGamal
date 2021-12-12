package project;

import java.util.ArrayList;
import java.util.Random;

public class RSA {

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
        System.out.println("numN: "+numN);

        //get L. L=lcm(p-1,q-1)
        long gcd = lib.findGCD(numP-1,numQ-1);
        long numL = ((numP-1)*(numQ-1))/gcd;
        System.out.println("numL: "+numL);


        //get E. where 1<E<L and gcd(E,L) =1
        Random currR = new Random();
        long numE;
        do{
            numE = currR.nextLong(numL-1);
        }while(lib.isRelativePrime(numL,numE) == false || numE<2);
        System.out.println("numE: "+numE);


        //Compute D where 1<D<L. E*D mod L =1;
        long numD;
        numD = lib.computeInverse(numE,numL);
        System.out.println("numD: "+numD);

        //store keys in arrayE,D,N
        System.out.println("\nkey set { numE:"+numE+", numD:"+numD+", numN:"+numN+"}");
        long[] keys = {numE,numD,numN};
        return keys;
    }

    public void encrypt(long numP, long numE, long numN){
        AlgorithmsLib lib = new AlgorithmsLib();
        long result = lib.fastExponentiationAlgorithm(numP,numE,numN);
        System.out.println("RSA encrypt result= "+result);
    }

    public long findDecryptionKey(long numE, long numM){
        //find factors of numD
        AlgorithmsLib lib = new AlgorithmsLib();
        System.out.println("find factors of numD："+numM);
        lib.primeFactors(numM);

        //find inverse of numE in phi(numD);
        System.out.println("find inverse of "+numE+" in phi("+numM+");");
        long phiM = lib.computePhiNumber(numM);
        System.out.println("phi("+numM+")="+phiM);
        long decryptionKey = lib.computeInverse(numE,phiM);
        System.out.println("Decryption key ="+decryptionKey);
        return decryptionKey;
    }

    public void decryptCiphertext(long numC, long numE, long numM){
        long decryptionKey = findDecryptionKey(numE,numM);
        AlgorithmsLib lib = new AlgorithmsLib();
        ArrayList<Long> primeFactors = lib.primeFactors(numM);

        long phi = (primeFactors.get(0)-1)*(primeFactors.get(1)-1);
        System.out.println("phi ="+phi);
        System.out.println("\nCompute c^e mod (d):");
        System.out.println(numC+","+decryptionKey+","+numM);
        long result = lib.fastExponentiationAlgorithm(numC,decryptionKey,numM);
        System.out.println("RSA decrypt result= "+result);
    }

    //sometime the same number while get incorrect answer.
    //like 622, it is checked as prime about 5% chance. So write a double check method.
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
