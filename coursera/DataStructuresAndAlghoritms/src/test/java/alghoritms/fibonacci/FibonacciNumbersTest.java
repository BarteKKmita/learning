package alghoritms.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumbersTest {

    @Test
    void shouldReturnFibonacciNumberWhenGivenElementNumber() {
        //Given
        long elementNumber = 10;
        long expectedFibonacciNumber = 55;
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        //When
        long actualFibonacciNumber = fibonacciNumbers.computeFibonacciNumber(elementNumber);
        //Then
        assertEquals(expectedFibonacciNumber, actualFibonacciNumber);
    }

    @Test
    @DisplayName("ComputingFibonacciNumberRecursively")
    void shouldReturnFibonacciNumber() {
        //Given
        long elementNumber = 80;
        long expectedFibonacciNumber = 23416728348467685L;
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        //When
        long actualFibonacciNumber = fibonacciNumbers.computeFibonacciNumberRecursively(elementNumber);
        //Then
        assertEquals(expectedFibonacciNumber, actualFibonacciNumber);
    }

    @Test
    void shouldThrowWhenNumberIsNegativeNumber() {
        //Given
        long elementNumber = -1;
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        //Then
        assertThrows( IllegalArgumentException.class,()-> fibonacciNumbers.computeFibonacciNumber(-1) );
    }

    @Test
    void shouldReturn0WhenNumberIs0() {
        //Given
        long elementNumber = 0;
        long expectedFibonacciNumber=0;
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        //When
        long actualFibonacciNumber = fibonacciNumbers.computeFibonacciNumber(elementNumber);
        //Then
        assertEquals(expectedFibonacciNumber, actualFibonacciNumber);
    }
}