package com.juhnkim;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertEquals(1, primeAtMax.getPrimes().size());
    }

    /**
     * CONSTRUCTOR TESTS
     */


}