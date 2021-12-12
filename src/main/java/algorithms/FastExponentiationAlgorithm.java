package algorithms;

public class FastExponentiationAlgorithm {
    public long fastExponentiation(long x, long e,long m)  //Solve (x^e) || (x^e)mod(m)
    {
        if(m>0)
        {
            return hasMod(x,e,m);
        }
        int loop=0;
        long y=1;
//        String result = "run"+loop+" [x:"+x+" e:"+e+" Y:"+y+"]";
        //System.out.println(result);
        while(e != 0)
        {
            loop++;
            if(isEven(e)==true)
            {
                x=(x*x);
                e= (long) (0.5*e);
                y=y;
            }else{
                x=x;
                e=e-1;
                y=(y*x);
            }
//            result = "run"+loop+" [x:"+x+" e:"+e+" Y:"+y+"]";
         //   System.out.println(result);
        }
        return y;
    }

    long hasMod(long x, long e,long m)  //(x^e)mod(m)
    {
        int loop=0;
        long y=1;
//        String result = "run"+loop+" [x:"+x+" e:"+e+" Y:"+y+"]";
//        System.out.println(result);
        while(e != 0)
        {
            loop++;
            if(isEven(e)==true)
            {
                x=(x*x)%m;
                e= (long) (0.5*e);
                y=y;
            }else{
                x=x;
                e=e-1;
                y=(y*x)%m;
            }
//            result = "run"+loop+" [x:"+x+" e:"+e+" Y:"+y+"]";
//            System.out.println(result);
        }
        return y;
    }

    boolean isEven(long num){
        if(num%2 ==0){
            return true;
        }else{
            return false;
        }
    }
}
