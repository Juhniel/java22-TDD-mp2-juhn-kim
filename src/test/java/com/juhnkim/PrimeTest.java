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
        // Check that the prime object is not null
        assertNotNull(prime.getPrimes());
        // Check if the prime list is empty
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
    @DisplayName("Test initializing constructor with a invalid range")
    void testConstructorForInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 1000));
        assertThrows(IllegalArgumentException.class, () -> new Prime(0, 1001));
        assertThrows(IllegalArgumentException.class, () -> new Prime(-20, 2000));
    }

    @Test
    @DisplayName("Test initializing constructor with inverted range")
    void testConstructorThrowsExceptionForInvertedRange() {
        assertThrows(IllegalArgumentException.class, () -> new Prime(1000, 0));
        assertThrows(IllegalArgumentException.class, () -> new Prime(500, 100));
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

    /**
     *  PRINT TESTS
     */

//    @Test
//    @DisplayName("Test print count")
//    void testPrintCount() {
//        Prime prime = new Prime(0, 1000);
//        assertEquals("Hej, det finns " + prime.getCount() +
//                " primtal mellan 0 och 1000!", prime.printCount());
//    }



}