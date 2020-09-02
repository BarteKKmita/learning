import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorTest {
    @Test
    void shouldReturnGreatestDivisorOfTwoNumbers(){
        //Given
        int numberA = 13;
        int numberB = 52;
        int expectedNumber = 13;
        //When
        int outputNumber = new Divisor().getGreatestCommonDivisor(numberA, numberB);
        //Then
        assertEquals(expectedNumber, outputNumber);
    }


    @Test
    void shouldReturnGreatestDivisorOfTwoNumbers2(){
        //Given
        int numberA = 52;
        int numberB = 52;
        int expectedNumber = 52;
        //When
        int outputNumber = new Divisor().getGreatestCommonDivisor(numberA, numberB);
        //Then
        assertEquals(expectedNumber, outputNumber);
    }
}