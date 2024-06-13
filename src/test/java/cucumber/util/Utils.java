package cucumber.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

    public static String removeTrailingDots(String text) {
        while (text.endsWith(".")) {
            text = text.substring(0, text.length() - 1);
        }

        return text;
    }

    public static boolean validateDate(String dateStr, String dateFormat) {
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
