package algorithms;
//1.2 the Extended Euclidean Algorithm
//Write and test code that will find a couple of integers, x0 and y0, for given
//integers m and n ,such that x0*m+y0*n will yield the smallest positive number.
//扩展欧几里得算法//辗转相除法的扩展//求最大公约数（gcd)的同时找到x，y两个数字来满足贝祖等式。
//贝祖等式 ax+by = gcd(a,b)
//after the first calculate, numA = numB and numB = remainder.
public class ExtendedEuclideanAlgorithm {
    public long computeInverse(long numA, long numB, long sOri, long sNew, long tOri, long tNew){
        long numInverse = extendedEuclideanAlgorithmFix(numA,numB,sOri,sNew,tOri,tNew);
        if(numInverse<0)
        {
            System.out.println("numInverse="+(numB-1)+numInverse);
            numInverse= numB+numInverse;
        }
        System.out.println("numInverse="+numInverse);
        return numInverse;
    }

    public long extendedEuclideanAlgorithmFix(long numA, long numB, long sOri, long sNew, long tOri, long tNew){
        long numQ = numA/numB; //compute quotient
        long sCurr = sOri-numQ*sNew;// compute sNew
        long tCurr = tOri-numQ*tNew;// compute tNew

        String result = "m = "+sNew + ", n = "+tNew;    //+" -> "+ sCurr +"*"+numA+"+"+tCurr+"*"+numB + "= 0";
        String step = numA+"/"+numB+"="+numQ+"+"+numA%numB+"  ";
        step += "si="+sOri+"-"+numQ+"*"+sNew+"="+sCurr+"    "; //Si
        step += "ti="+tOri+"-"+numQ+"*"+tNew+"="+tCurr; //Ti
        System.out.println(step);
        if(numB ==1)  // check stop point
        {
            System.out.println("GCD = 1, they are relatively prime.");
            System.out.println(result);
            return sNew;
        }
        long numR= numA%numB; //compute remainder numR
        if(numR ==0){ // check stop point
            System.out.println("GCD ="+numB+", they are not relatively prime.");
            System.out.println(result);
            return 0;
        }else{
            long numInverse = extendedEuclideanAlgorithmFix(numB, numR,sNew,sCurr,tNew,tCurr);
            return numInverse;
        }
    }

    public boolean booleanExtendedEuclideanAlgorithm(int numA, int numB, int sOri, int sNew, int tOri, int tNew){

        int numQ = numA/numB; //compute quotient
        int sCurr = sOri-numQ*sNew;// compute sNew
        int tCurr = tOri-numQ*tNew;// compute tNew

        String result = "m = "+sNew + ", n = "+tNew;    //+" -> "+ sCurr +"*"+numA+"+"+tCurr+"*"+numB + "= 0";
        String step = numA+"/"+numB+"="+numQ+"+"+numA%numB+"  ";
        step += "si="+sOri+"-"+numQ+"*"+sNew+"="+sCurr+"    "; //Si
        step += "ti="+tOri+"-"+numQ+"*"+tNew+"="+tCurr; //Ti
//        System.out.println(step);
        if(numB ==1)  // check stop point
        {
//            System.out.println("GCD = 1, they are relatively prime.");
//            System.out.println(result);
            return true;
        }
        int numR= numA%numB; //compute remainder numR
        if(numR ==0){ // check stop point
//            System.out.println("GCD ="+numB+", they are not relatively prime.");
//            System.out.println(result);
            return true;
        }else{
            return booleanExtendedEuclideanAlgorithm(numB, numR,sNew,sCurr,tNew,tCurr);
        }
    }
}
