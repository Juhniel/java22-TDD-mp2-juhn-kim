# java22-TDD-mp2-juhn-kim


# Overview
This project is designed for the 'Prime' class in Java for JUnit testing purposes. The class is responsible for identifying prime numbers within a specified range between 0-1000.

*Red-Green-Refactor* 

# Key Features
The tests covers the following features of the 'Prime' class:
* Construction Behavior
* Prime Number Identification
* Exception Handling 

# Constructor Tests
* Testing with valid ranges, including small and large intervals.
* Verifying the class throws exceptions with specific messages for invalid ranges such as negative values, ranges outside 0-1000 and inverted ranges.
* Ensuring that the prime number list is initialized-

# Getters Tests
* getPrimes - To check if the returned list of prime numbers is correct.
* getCount - To verify the correct number of prime numbers.
* getSumOfPrimes - To verify the sum of the prime numbers.

# Important Tests
* Boundary Conditions
* Valid input 
* Exceptions 

# Reflection and Conclusion 

Reflecting on the refactoring and testing process for the original 'Prime' class where I identified areas for improvement and 
enhancing readability.

The original code had complex recursive logic, especially in the numIsPrime() method, which was refactored for better clarity and 
corrected logic. 

Regarding the tests I covered a wide range of scenarios but strategically did not include tests for null values or data type validation.
Since the implementation of the constructors and methods do not accept or return values where null or data type mismatch might occur.

I also skipped testing printSum() and printCount() method since the focus was rather on the getter methods. Since the print methods
only show text and the importance of the method is making sure that the getters methods are displayed correctly.

The tests for the prime logic was tested more indirectly since the methods were private to the 'Prime' class.
By testing the private prime number logic indirectly through the public interface, 
this approach ensures that the internal implementation details of the Prime class remain encapsulated.