import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTailRecurencyTest {

    @Test
    void shouldReturnFactorialOfNumber(){
        //Given
        int number = 4;
        int expectedOutput=24;
        //When
        int outputNumber=new FactorialTailRecurency().getFactorial(number);
        //Then
        assertEquals(expectedOutput, outputNumber);
    }
}