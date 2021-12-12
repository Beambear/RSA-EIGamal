package project;

import algorithms.*;

import java.util.ArrayList;

public class AlgorithmsLib {
    //1.1 Euclidean Algorithm
    //1.2 the Extended Euclidean Algorithm
    //Write and test code that will find a couple of integers, x0 and y0, for given
    //integers m and n ,such that x0*m+y0*n will yield the smallest positive number.
    //1.3 Compute multiplicative Inverse. //同Ext Euclidean, return number rather than return true/false.
    //1.4 find prime factor of n.//找质因数
    //1.4 Sieve of eratosthenes: find all prime numbers less than n. //埃拉托斯特尼筛法
    //1.5 Compute phi: find relatively numbers of n, and get phi value.//找相对质数
    //2.1 Find Divisor of n.    //找因数
    //3.1 Fast exponentiation algorithm     //快速幂
    //4.1 Primitive Root Search Algorithm. //求原根，确认cyclic group
    //4.2 Baby-Step Giant-Step Algorithm    //find log(numB）numA in Zx(numC).
    //4.3 Compute mod 1.      //compute {(numA)^(numE)} mod(numM)
    //4.4 Compute mod 2.      //compute log(numA)numB mod(numM)
    //5.1 rsaEncrypt    //compute RSA encrypt result
    //5.2 rsaFindDecryptionKey //find decryption key by given Keypub(numE, numD)
    //5.3 rsaDecrypt    //decrypt ciphertext by given Ciphertext and Keypub(numE,numD)
    //9.1 MillerRabinTest //check if a number is pseudo prime number
    //10.1 Blum-Blum-Shub Random Number Generator

    //1.2
    public long computeInverse(long numA, long numB){
        ExtendedEuclideanAlgorithm doIt = new ExtendedEuclideanAlgorithm();
        return doIt.computeInverse(numA, numB,1,0,0,1);
    }

    //1.4
    public ArrayList<Long> primeFactors(long n){
        PrimeFactors doIt = new PrimeFactors();
        return doIt.primeFactors(n);
    }

    //1.5
    public ArrayList<Long> computePhi(long numN){
        ComputePhi doIt = new ComputePhi();
        return doIt.computePhi(numN);
    }

    public long computePhiNumber(long numN){
        ComputePhi doIt = new ComputePhi();
        return doIt.computePhiNumber(numN);
    }
    //3.1
    public long fastExponentiationAlgorithm(long x,long e, long m){
        FastExponentiationAlgorithm doIt = new FastExponentiationAlgorithm();
        return doIt.fastExponentiation(x,e,m);
    }

    //9.1
    public boolean millerRabinTest(long numTest){
        MillerRabinTest doIt = new MillerRabinTest();
        return doIt.millerRabinTest(numTest);
    }

    //10.1
    public long getBBSRandomNumber(){
        BBSRandomNumber doIt = new BBSRandomNumber();
        return doIt.randomNumberBSS();
    }
}
