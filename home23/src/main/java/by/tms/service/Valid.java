package by.tms.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
    public static boolean validateDouble(String num) {

        Pattern pattern = Pattern.compile("\\-\\d*\\.?\\d{0,20}|\\d*\\.?\\d{0,20}");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
    public static boolean validateType(String type){
        Pattern pattern = Pattern.compile("^sum$|^sub$|^div$|^mul$");
        Matcher matcher = pattern.matcher(type);
        return matcher.matches();
    }

}
