package algorithms;

public class BBSRandomNumber {
    public long getRandomPQ(){
        long randomDigits = (long) (Math.random()*(10-5));
        long digits =1;
        for(int i=0; i< randomDigits;i++){
            digits*=10;
        }
        long randomNum = (long) ((Math.random()*9+1)*digits);

        if(is3Mod4(randomNum)==true)
        {
            return randomNum;
        }

        return randomNum;
    }

    public boolean is3Mod4(long num){
        long result = num%4;
        if(result == 3)
        {
            return true;
        }else{
            return false;
        }
    }
}
