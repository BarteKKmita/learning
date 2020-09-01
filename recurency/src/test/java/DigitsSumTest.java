import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitsSumTest {

    @Test
    void shouldCountDigits(){
        //Given
        int number=123549;
        int expectedDigitsCount=24;
        DigitsSum digitsSum = new DigitsSum();
        //When
        int actualDigitsSum = digitsSum.getDigitsSum(number);
        //Then
        assertEquals(expectedDigitsCount, actualDigitsSum);
    }

}