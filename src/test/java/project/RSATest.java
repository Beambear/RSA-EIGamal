package project;

import org.junit.Test;

import static org.junit.Assert.*;

public class RSATest {

    @Test
    public void encrypt() {
        RSA test = new RSA();
        assertEquals(3279901,test.encrypt(1234,1523917,8638613));
    }

    @Test
    public void decrypt() {
        RSA test = new RSA();
        assertEquals(6666,test.decrypt(660754,607513,1230043));
    }

    @Test
    public void eavesdropDecryptCiphertext() {
        RSA test = new RSA();
        assertEquals(9876,test.eavesdropDecryptCiphertext(495895154,7687,532617791));
    }
}