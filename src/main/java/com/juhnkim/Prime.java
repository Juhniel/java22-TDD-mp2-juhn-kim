package com.juhnkim;

import java.util.ArrayList;
import java.util.List;

/**
 * This program counts the sum and the number of prime (int) numbers in interval 0-1000
 */
public class Prime {

    private final List<Integer> primes;
    private int count = 0;
    private int sumOfPrimes = 0;

    public Prime(int firstNumber, int lastNumber) {
        if (firstNumber < 0 || firstNumber > 1000 || lastNumber < 0 || lastNumber > 1000) {
            throw new IllegalArgumentException("Numbers must be between 0 and 1000");
        }
        if (firstNumber > lastNumber) {
            throw new IllegalArgumentException("First number must be less than or equal to last number");
        }

        primes = new ArrayList<>();
        calculatePrimes(firstNumber, lastNumber);
    }

    private boolean numIsPrime(int current, int depth) {
        if(current <= 1) {
            return false;
        }

        if (current % 2 == 0) {
            return current == 2;
        }

        for (int i = 3; i <= Math.sqrt(current); i += 2) {
            if (current % i == 0) {
                return false;
            }
        }

        if (depth >= primes.size()) {
            return true;
        }

        int divisibleBy = primes.get(depth);
        if (current % divisibleBy == 0) {
            return false;
        }
        return numIsPrime(current, ++depth);
    }



    private void calculatePrimes(int current, int stop) {
        if (current > stop) {
            return;
        }

        if (numIsPrime(current, 0)) {
            primes.add(current);
            count++;
            sumOfPrimes += current;
        }
        calculatePrimes(++current, stop);
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public int getCount() {
        return count;
    }

    public int getSumOfPrimes() {
        return sumOfPrimes;
    }

    public void printCount() {
        System.out.println("Hej, det finns " + getCount() + " primtal mellan 0 och 1000!");
    }

    public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + getSumOfPrimes());
    }


    public static void main(String[] args) {
//        Prime prime = new Prime(0, 10);
//        System.out.println(prime.getPrimes());

        Prime prime = new Prime(0, 30);
        System.out.println(prime.getPrimes());
    }
}

