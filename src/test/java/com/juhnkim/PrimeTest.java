package com.juhnkim;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    /**
     * CONSTRUCTOR TESTS
     */
    @Test
    @DisplayName("Test initializing constructor")
    void testConstructorInitializer() {
        Prime prime = new Prime(0, 1000);
        assertNotNull(prime.getPrimes());
        assertFalse(prime.getPrimes().isEmpty());
    }

    @Test
    @DisplayName("Test initializing constructor for a small valid range")
    void testPrimeCalculationForSmallRange() {
        Prime prime = new Prime(0, 10);

        int[] expectedPrimes = {2, 3, 5, 7};
        for (int expectedPrime : expectedPrimes) {
            assertTrue(prime.getPrimes().contains(expectedPrime));
        }

        assertEquals(expectedPrimes.length, prime.getPrimes().size());
    }

    @Test
    @DisplayName("Test specific exception message for invalid range")
    void testExceptionMessageForInvalidRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 1000));
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }

    @Test
    @DisplayName("Test specific exception message for inverted range")
    void testExceptionMessageForInvertedRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(1000, 0));
        assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
    }


    @Test
    @DisplayName("Test initializing constructor for boundary values")
    void testConstructorForBoundaryValues() {
        Prime primeAtZero = new Prime(0, 0);
        assertTrue(primeAtZero.getPrimes().isEmpty());

        Prime primeAtMax = new Prime(1000, 1000);
        assertEquals(0, primeAtMax.getPrimes().size());
    }

    /**
     *  GETTERS & SETTERS TESTS
     */
    @Test
    @DisplayName("Test getPrimes for a valid range")
    void testGetPrimes() {
        Prime prime = new Prime(10, 20);
        List<Integer> expectedPrimes = Arrays.asList(11, 13, 17, 19);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("Test getPrimes for a valid lower bound range")
    void testGetPrimesLowerInterval() {
        Prime prime = new Prime(0, 100);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43,47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("Test getPrimes for a valid upper bound range")
    void testGetPrimesUpperInterval() {
        Prime prime = new Prime(900, 1000);
        List<Integer> expectedPrimes = Arrays.asList(907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("Test count of primes for a known range")
    void testCountOfPrimes() {
        Prime prime = new Prime(0, 10);
        assertEquals(4, prime.getCount());
    }

    @Test
    @DisplayName("Test sum of primes for a known range")
    void testSumOfPrimes() {
        Prime prime = new Prime(0, 10);
        int expectedSum = 2 + 3 + 5 + 7;
        assertEquals(expectedSum, prime.getSumOfPrimes());
    }

    @Test
    @DisplayName("Test for extreme lower limit")
    void testExtremeLowerLimit() {
        Prime prime = new Prime(0, 2);
        assertEquals(List.of(2), prime.getPrimes());
    }

    @Test
    @DisplayName("Test for extreme upper limit")
    void testExtremeUpperLimit() {
        Prime prime = new Prime(998, 1000);
        assertTrue(prime.getPrimes().isEmpty());
    }

    @Test
    @DisplayName("Test range with no primes")
    void testRangeWithNoPrimes() {
        Prime prime = new Prime(24, 25);
        assertTrue(prime.getPrimes().isEmpty());
    }

    @Test
    @DisplayName("Test single prime")
    public void testSingleNumberRange() {
        Prime prime = new Prime(7, 7);
        assertNotNull(prime.getPrimes());
        assertEquals(1, prime.getCount());
        assertEquals(7, prime.getSumOfPrimes());
    }

}