package algorithms;

import java.util.ArrayList;

public class BabyStepGiantStep {
    public long bsbg(long generator,long publicKeyAlice, long numP){
        //pre compute m
        // generator in EIGamal always the generator of numP.
        long numB = generator;
        long numE = publicKeyAlice;
        double currNumM = Math.sqrt(numP);
        currNumM = (Math.round(currNumM*100));
        currNumM = currNumM/100;
        int numM = (int) (Math.round(currNumM*100)/100);


        //i.Compute b^j for 0<=j<m.
        ArrayList<Long> bJList = new ArrayList<Long>();
        for(int i=0;i<numM;i++){
            FastExponentiationAlgorithm doFast = new FastExponentiationAlgorithm();
            long currBJ = doFast.fastExponentiation(numB,i,0);
            bJList.add(currBJ);
        }

        //ii.obtain pairs(j,bJ%numC) for 0<=j<m;
        ArrayList<Long> bJModList = new ArrayList<Long>();
        for(int i=0;i<numM;i++){
            FastExponentiationAlgorithm doFast = new FastExponentiationAlgorithm();
            long currBJMod = doFast.fastExponentiation(numB,i,numP);
            bJModList.add(currBJMod);
        }

        //iii. Compute c=(b^-1)^m. Other words, (B^-1)^m in Zx(c)
        //iii.1 Compute (b^-1), the inverse of b in c.  where c = numP
        ExtendedEuclideanAlgorithm doExt = new ExtendedEuclideanAlgorithm();
        long bInverse = doExt.computeInverse(numB,numP,1,0,0,1);

        //iii.2 Compute bInverse^m=c by fast exponentiation algorithm.
        FastExponentiationAlgorithm doFast = new FastExponentiationAlgorithm();
        long bResult = doFast.fastExponentiation(bInverse,numM,numP);

        //iv compute left and search in right.
        // initialize numX = numB;
        long numX = numE;
        long result;
        //calculate a*(b-1)^(i) mod P to find the same value in bJ
        for(int i=0; i<numM; i++)
        {
            long left = doFast.fastExponentiation(bResult,i,0); //(b-1)^i
            left = numE*left;   //a*(b-1)^i
            left = doFast.fastExponentiation(left,1,numP);  //a*(b-1)^(i) mod P
            System.out.println("When i="+i+", left="+left);

            for(int j=0;j<bJModList.size();j++){
                long currBJMod = bJModList.get(j);
                if(left == currBJMod){
                    System.out.println("i="+i+", numM="+numM+", j="+j);
                    result = i*numM +j;
                    return result;
                }
            }

        }
        System.out.println("search failed");
        result = numX * bResult;
        return result;
    }
}
