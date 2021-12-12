package project;

public class Main {

    public static void main(String[] args) {
        Main driver = new Main();
        driver.rsaSet();

    }

    public void rsaSet(){
        AlgorithmsLib test = new AlgorithmsLib();
        RSA doIt = new RSA();
        doIt.generateKeys();
//        doIt.encrypt(1234,1523917  ,8638613);
//        doIt.decrypt( 380701, 368013 ,534757);
//        doIt.eavesdropDecryptCiphertext( 380701,245417,534757);
    }
}
