package alghoritms.maxpairwise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MaxPairwiseProductTest {

    @Test
    void shouldMultiplyTwoBiggestNumbers() {
        //Given
        List<Integer> numbers = createListOfNumbers();
        MaxPairwiseProduct maxPairwiseProduct = new MaxPairwiseProduct();
        long expectedNumber = 231 * 123;
        //When
        long actualMaxPairwiseProduct = maxPairwiseProduct.getMaxPairwiseProduct(numbers);
        //Then
        assertEquals(expectedNumber, actualMaxPairwiseProduct);
    }

    @Test
    void shouldNotThrowWhenTwoMaxIntegers() {
        //Given
        List<Integer> maxIntegers = getMaxIntegersList();
        MaxPairwiseProduct maxPairwiseProduct = new MaxPairwiseProduct();
        long expectedNumber = (long) Integer.MAX_VALUE * (long) Integer.MAX_VALUE;
        //Then
        assertDoesNotThrow(() -> maxPairwiseProduct.getMaxPairwiseProduct(maxIntegers));
        assertEquals(expectedNumber, maxPairwiseProduct.getMaxPairwiseProduct(maxIntegers));
    }

    @Test
    void shouldThrowWhenLessThen2ElementInList() {
        //Given
        List<Integer> maxIntegers = List.of(1);
        MaxPairwiseProduct maxPairwiseProduct = new MaxPairwiseProduct();
        //Then
        assertThrows(IllegalArgumentException.class, () -> maxPairwiseProduct.getMaxPairwiseProduct(maxIntegers));
    }

    @Test
    @DisplayName("Efficiency test.")
    void shouldProvideOutputInLessThenSecond() {
        //Given
        List<Integer> maxIntegers = getLargeList();
        MaxPairwiseProduct maxPairwiseProduct = new MaxPairwiseProduct();
        long maximumTime = 60000;
        //When
        long start = System.currentTimeMillis();
        maxPairwiseProduct.getMaxPairwiseProduct(maxIntegers);
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        //Then
        assertTrue(elapsedTimeMillis < maximumTime);
    }

    private List<Integer> getLargeList() {
        Integer[] numbers = new Integer[1000000];
        for(int i = 0; i < 1000000; i++) {
            numbers[i] = new Random().nextInt();
        }
        return Arrays.asList(numbers);
    }


    private List<Integer> getMaxIntegersList() {
        return List.of(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    private List<Integer> createListOfNumbers() {
        return List.of(1, 231, 4, 123, 4, 6, 8, 78);
    }
}