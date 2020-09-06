package alghoritms.fibonacci;

public class FibonacciNumbers {

    public long computeFibonacciNumber(long elementNumber) {
        if (checkElementNumber(elementNumber) != null)
            return checkElementNumber(elementNumber);
        long previousNumber2 = 0;
        long previousNumber1 = 1;
        for(int i = 2; i < elementNumber; i++) {
            long temp = previousNumber1;
            previousNumber1 = previousNumber1 + previousNumber2;
            previousNumber2 = temp;
        }
        return previousNumber1 + previousNumber2;

    }

    public long computeFibonacciNumberRecursively(long elementNumber) {
        if (checkElementNumber(elementNumber) != null)
            return checkElementNumber(elementNumber);
        long previousNumber2 = 0;
        long previousNumber1 = 1;
        return countFibonacciRecursively(elementNumber, previousNumber2, previousNumber1);

    }

    private Long checkElementNumber(long elementNumber) {
        if (elementNumber < 0) {
            throw new IllegalArgumentException("Inserted element cannot be lower than 0.");
        }
        if (elementNumber == 0) {
            return 0L;
        } else if (elementNumber == 1) {
            return 1L;
        }
        return null;
    }

    private long countFibonacciRecursively(long elementNumber, long previousNumber2, long previousNumber1) {
        if (elementNumber == 2) {
            return previousNumber1 + previousNumber2;
        } else {
            long temp = previousNumber1;
            previousNumber1 = previousNumber1 + previousNumber2;
            previousNumber2 = temp;
            return countFibonacciRecursively(elementNumber - 1, previousNumber2, previousNumber1);
        }
    }
}
