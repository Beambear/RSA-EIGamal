package algorithms;
    //1.1 Euclidean Algorithm
    //Find the greatest common divisors
    //辗转相除法//欧几里得算法//求最大公约数（GCD）
public class EuclideanAlgorithm {
        public boolean euclideanAlgorithm(long numA, long numB){
            if(numA < 0 || numB < 0)
            {
                System.out.println("numA or numB should be positive");
            }else if (numA < numB){
                long numT = numA;
                numA =numB;
                numB =numT;
            }
            long numR= numA%numB;
            long numC= numA/numB;
            String step= (numA+"="+numC+"*"+numB+"+"+numR);
            if(numB ==1)
            {
                //System.out.println("GCD = 1, they are relatively prime.");
                return true;
            }
            if(numR ==0){
                System.out.println(step);
                //System.out.println("GCD ="+numB+", they are not relatively prime.");
                return false;
            }else{
                System.out.println(step);
                return euclideanAlgorithm(numB, numR);
            }
        }
}
