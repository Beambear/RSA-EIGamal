package algorithms;

import java.util.ArrayList;

public class PrimitiveRootSearchAlgorithm {

    public boolean isPrimitiveRoot(long numTry, long numP)
    {
        PrimeFactor doIt = new PrimeFactor();
        ArrayList<Long> factors = doIt.primeFactors(numP-1);
        for(int i=0; i< factors.size();i++)
        {
            FastExponentiationAlgorithm pow = new FastExponentiationAlgorithm();
            long test = pow.fastExponentiation(numTry,factors.get(i),numP);
            if(test ==1){
                return false;
            }
        }
        return true;
    }
}
