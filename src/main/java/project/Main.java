package project;

import java.util.Scanner;

public class Main {

    public void test(){
        System.out.println("test");
        RSA test = new RSA();
        test.eavesdropDecryptCiphertextForString(2090299036L,"2677074319","4048479451");
        long result = 2090299036;
        System.out.println(result);

//        BabyStepGiantStep test = new BabyStepGiantStep();
//        long result = test.bsbg(541239,845216,890231);
//        System.out.println(result);
    }
    public static void main(String[] args) {
        Main driver = new Main();
        System.out.println("1.EIGamal\n2.RSA");
        Scanner keyBoard = new Scanner(System.in);
        String inPut = keyBoard.next();
        switch(inPut){
            case "1":
                driver.eIGamalSet();
                break;
            case "2":
                driver.rsaSet();
                break;
            case "3":
                driver.test();
                break;
        }

    }

    public void eIGamalSet(){
        EIGamal doIt = new EIGamal();
        System.out.println("\nEIGamal:\n1.generate key set\n2.encrypt\n3.decrypt\n4.eaves drop & decrypt");
        Scanner keyBoard = new Scanner(System.in);
        String inPut = keyBoard.next();
        switch(inPut){
            case "1":
                doIt.generateKeys();
                break;
            case "2":
                System.out.print("enter plain text");
                long txtP = Long.parseLong(keyBoard.next());
                System.out.print("enter prime number:");
                long numP = Long.parseLong(keyBoard.next());
                System.out.print("enter generator:");
                long numG = Long.parseLong(keyBoard.next());
                System.out.print("enter public key");
                long numKey = Long.parseLong(keyBoard.next());
                doIt.encrypt(txtP,numP,numG,numKey);
                break;
            case "3":
                System.out.print("enter public key");
                long numKey2 = Long.parseLong(keyBoard.next());
                System.out.print("enter cipher text");
                String numCipher = keyBoard.next();
                System.out.print("enter secret key");
                String keyS = keyBoard.next();
                System.out.print("enter prime number");
                long numP2 = Long.parseLong(keyBoard.next());
                doIt.decrypt(numKey2,numCipher, keyS,numP2);
                break;
            case "4":
                System.out.print("enter prime number");
                long numP4 = Long.parseLong(keyBoard.next());
                System.out.print("enter generator");
                long generator4 = Long.parseLong(keyBoard.next());
                System.out.print("enter public key Alice");
                long pubKA4 = Long.parseLong(keyBoard.next());
                System.out.print("enter public key Bob");
                long pubKB4 = Long.parseLong(keyBoard.next());
                System.out.print("enter cipher text");
                String cipherText4 = keyBoard.next();
                doIt.eavesdropDecryptCiphertext(numP4,generator4,pubKA4,cipherText4,pubKB4);
                break;
        }
//        doIt.generateKeys();
//        doIt.encrypt(1234,33432023,5,10791381);
//        doIt.decrypt(268522239 , "246520","346768458752",890231);
//        doIt.eavesdropDecryptCiphertext(890231,541239,845216,"246520",680806);
    }

    public void rsaSet(){
        AlgorithmsLib test = new AlgorithmsLib();
        RSA doIt = new RSA();
        System.out.println("RSA:\n1.generate key set\n2.encrypt\n3.decrypt\n4.eaves drop & decrypt\n5.find decryption key");
        Scanner keyBoard = new Scanner(System.in);
        String inPut = keyBoard.next();
        switch(inPut){
            case "1":
                doIt.generateKeys();
                break;
            case "2":
                System.out.print("enter plain text");
                long txtP = Long.parseLong(keyBoard.next());
                System.out.print("enter public key E");
                long numE = Long.parseLong(keyBoard.next());
                System.out.print("enter prime number N");
                long numN = Long.parseLong(keyBoard.next());
                doIt.encrypt(txtP,numE,numN);
                break;
            case "3":
                System.out.print("enter cipher text C:");
                long txtC = Long.parseLong(keyBoard.next());
                System.out.print("enter secret key D:");
                long numD = Long.parseLong(keyBoard.next());
                System.out.print("enter prime number N:");
                long numN2 = Long.parseLong(keyBoard.next());
                doIt.decrypt(txtC,numD,numN2);
                break;
            case "4":
                System.out.print("enter cipher text C:");
                long txtC4 = Long.parseLong(keyBoard.next());
                System.out.print("enter public key E:");
                long keyPub4 = Long.parseLong(keyBoard.next());
                System.out.print("enter prime number N:");
                long numN4 = Long.parseLong(keyBoard.next());
                doIt.eavesdropDecryptCiphertext(txtC4,keyPub4,numN4);
                break;
            case "5":
                System.out.print("enter public key E:");
                long keyPub5 = Long.parseLong(keyBoard.next());
                System.out.print("enter prime number N:");
                long numN5 = Long.parseLong(keyBoard.next());
                doIt.findDecryptionKey(keyPub5,numN5);
                break;
        }
//        doIt.generateKeys();
//        doIt.encrypt(1234,1523917  ,8638613);
//        doIt.decrypt( 660754, 607513 ,1230043);
//        doIt.findDecryptionKey(7687,532617791);
//        doIt.eavesdropDecryptCiphertext( 660754,281929,1230043);
    }
}
