public class Divisor {

    int getGreatestCommonDivisor(int firstNumber, int secondNumber){
int biggerNumber;
int lowerNumber;
if(firstNumber>secondNumber){
    biggerNumber=firstNumber;
    lowerNumber=secondNumber;
}else{
    biggerNumber=secondNumber;
    lowerNumber=firstNumber;
}
return getGreatestCommonDivisorAuxillary(biggerNumber, lowerNumber);
    }

    private int getGreatestCommonDivisorAuxillary(int biggerNumber, int lowerNumber){
       if(biggerNumber%lowerNumber==0){
           return lowerNumber;
       }else
           return getGreatestCommonDivisorAuxillary(lowerNumber,  biggerNumber%lowerNumber);
    }

}
