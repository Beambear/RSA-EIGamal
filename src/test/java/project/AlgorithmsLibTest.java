package project;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AlgorithmsLibTest {

    @Test
    public void findGCD() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertEquals(1,test.findGCD(7,23)   );
    }

    @Test
    public void isRelativePrime() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertTrue(test.isRelativePrime(5324,1131));
        assertFalse(test.isRelativePrime(748077,1110540));
    }

    @Test
    public void computeInverse() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertEquals(0,test.computeInverse(7483077,1110540));
        assertEquals(9,test.computeInverse(5,11));
    }

    @Test
    public void primeFactors() {
        AlgorithmsLib test = new AlgorithmsLib();
        ArrayList<Long> testResult = test.primeFactors(130);
        ArrayList<Long> expResult = new ArrayList<Long>();
        expResult.add(2L);
        expResult.add(5L);
        expResult.add(13L);
        assertEquals(expResult,testResult);
    }

    @Test
    public void computePhi() {
        AlgorithmsLib test = new AlgorithmsLib();
        ArrayList<Long> expResult = new ArrayList<Long>();
        expResult.add(1L);
        expResult.add(3L);
        expResult.add(7L);
        expResult.add(9L);
        expResult.add(11L);
        expResult.add(13L);
        expResult.add(17L);
        expResult.add(19L);
        assertEquals(expResult, test.computePhi(20));
    }

    @Test
    public void computePhiNumber() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertEquals(40, test.computePhiNumber(100));
    }

    @Test
    public void fastExponentiationAlgorithm() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertEquals(45,test.fastExponentiationAlgorithm(87,10,131));
        assertEquals(9340,test.fastExponentiationAlgorithm(1235,542,12355));
    }

    @Test
    public void isPrimitiveRoot() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertTrue(test.isPrimitiveRoot(61,66));
    }

    @Test
    public void babyStepGiantStep() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertEquals(5,test.babyStepGiantStep(2,3,29));
        assertEquals(69,test.babyStepGiantStep(2,3,101));
    }

    @Test
    public void millerRabinTest() {
        AlgorithmsLib test = new AlgorithmsLib();
        assertTrue(test.millerRabinTest(54577));
        assertFalse(test.millerRabinTest(686667));
    }

    @Test
    public void getBBSRandomNumber() {
    // N/A
    }

    @Test
    public void getBBSPrimeNumber() {
        AlgorithmsLib test = new AlgorithmsLib();
        long testNumber = test. getBBSPrimeNumber();
        assertTrue(test.millerRabinTest(testNumber));
    }

    @Test
    public void getBBSPNforEIGamal() {
        AlgorithmsLib test = new AlgorithmsLib();
        long testNumber = test. getBBSPrimeNumber();
        assertTrue(test.millerRabinTest(testNumber));
    }
}