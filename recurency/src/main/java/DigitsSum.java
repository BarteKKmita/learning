public class DigitsSum {

     int getDigitsSum(int number){
         if(number<10){
             return number;
         }
         else{
             return number%10+ getDigitsSum(number/10);
         }
     }
}
