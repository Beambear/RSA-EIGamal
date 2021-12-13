package project;

public class Main {

    public static void main(String[] args) {
        Main driver = new Main();
        driver.rsaSet();
//        driver.eIGamalSet();
    }

    public void eIGamalSet(){
        EIGamal doIt = new EIGamal();
//        doIt.generateKeys();
//        doIt.encrypt(1234,33432023,5,10791381);
//        doIt.decrypt(268522239 , "18391679760",271828212,471532157);
    }

    public void rsaSet(){
        AlgorithmsLib test = new AlgorithmsLib();
        RSA doIt = new RSA();
        doIt.generateKeys();
//        doIt.encrypt(1234,1523917  ,8638613);
//        doIt.decrypt( 660754, 607513 ,1230043);
//        doIt.findDecryptionKey(7687,532617791);
//        doIt.eavesdropDecryptCiphertext( 495895154,7687,532617791);
    }
}
