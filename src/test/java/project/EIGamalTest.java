package project;

import org.junit.Test;

import static org.junit.Assert.*;

public class EIGamalTest {

    @Test
    public void encrypt() {
        EIGamal test = new EIGamal();
        test.encrypt(1234,33432023,5,10791381);
    }

    @Test
    public void decrypt() {
        EIGamal test = new EIGamal();
        assertEquals(11111,test.decrypt(845216,"246520","45430",890231));
    }

    @Test
    public void eavesdropDecryptCiphertext() {
        EIGamal test = new EIGamal();
//        long result = test.eavesdropDecryptCiphertext(6587389,20630290,374827,"5432180",2197646);
//        assertEquals(321,result);
        long result2 = test.eavesdropDecryptCiphertext(19027597,13313210,12450342,"12955689288",16710030);
        assertEquals(789,result2);
    }
}