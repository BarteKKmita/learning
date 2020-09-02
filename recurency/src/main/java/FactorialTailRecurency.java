public class FactorialTailRecurency {

    int getFactorial(int number){
return getFactorialAux(number,0);
    }

    private int getFactorialAux(int number, int numberToReturn){
       if(number==0){
           return numberToReturn;
       }else {
           return getFactorialAux(number - 1,numberToReturn*number );
       }
    }
}
