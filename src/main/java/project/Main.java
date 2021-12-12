package project;

public class Main {

    public static void main(String[] args) {
//	// write your code here
        AlgorithmsLib test = new AlgorithmsLib();
        RSA doIt = new RSA();
//        System.out.println(doIt.generateKeys());//
        doIt.encrypt(12345,552659,9121481);
        System.out.println("break");
        doIt.decryptCiphertext(4704635,1380605,3041099);
        System.out.println("find key");
//        doIt.findDecryptionKey(1380605,3041099);


    }
}
