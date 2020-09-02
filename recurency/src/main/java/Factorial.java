public class Factorial {

    int getFactorial(int number){
        if(number==0){
            return 1;
        }else return number*getFactorial(number-1);
    }
}
