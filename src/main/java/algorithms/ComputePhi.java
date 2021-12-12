package algorithms;

import java.util.ArrayList;

public class ComputePhi {
    public boolean isRelativelyPrime(long numC, long numN)
    {
        EuclideanAlgorithm check = new EuclideanAlgorithm();
        return check.euclideanAlgorithm(numC,numN);
    }

    public ArrayList<Long> computePhi(long numN)
    {
        ArrayList<Long> numRP = new ArrayList<Long>();
        for(long i=1;i<numN;i++)
        {
//            System.out.println("\n["+i+","+numN+"]");
            if(isRelativelyPrime(i,numN)==true)
            {
                numRP.add(i);
            }
        }
//        System.out.println("\nphi("+numN+")="+numRP.size());
//        System.out.println(numRP);
        return numRP;
    }

    public long computePhiNumber(long numN)
    {
        ArrayList<Long> numRP = new ArrayList<Long>();
        for(long i=1;i<numN;i++)
        {
//            System.out.println("\n["+i+","+numN+"]");
            if(isRelativelyPrime(i,numN)==true)
            {
                numRP.add(i);
            }
        }
//        System.out.println("\nphi("+numN+")="+numRP.size());
        System.out.println(numRP);
        return numRP.size();
    }
}
