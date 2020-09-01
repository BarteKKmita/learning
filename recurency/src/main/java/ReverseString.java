import com.google.common.base.Strings;

public class ReverseString {

    String getReversedString(String stringToReverse){
        getReversedStringAuxiliary(stringToReverse);
    }

    private String getReversedStringAuxiliary(String stringToReverse){
        if(Strings.isNullOrEmpty(stringToReverse)){
            return "";
        } else{
            return stringToReverse.charAt(stringToReverse.length()-1+getReversedStringAuxiliary(stringToReverse.substring(0,stringToReverse.length()-2));
    }
    }
}
