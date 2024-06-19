package cucumber.util;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, String> replaceNullValuesWithEmptyStrings(Map<String, String> map) {
        Map<String, String> updatedMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                updatedMap.put(entry.getKey(), "");
            } else {
                updatedMap.put(entry.getKey(), entry.getValue());
            }
        }
        return updatedMap;
    }

    public static boolean verifyDownloadedFile(String fileName) {
        File folder = new File(System.getProperty("user.dir") + "\\src\\test\\resources");
        File[] listOfFiles = folder.listFiles();
        boolean isFilePresent = false;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains(fileName)) {
                isFilePresent = true;

            }
        }
        return isFilePresent;
    }

    public static boolean deleteDownloadedFile(String fileName) {
        File folder = new File(System.getProperty("user.dir") + "\\src\\test\\resources");
        File[] listOfFiles = folder.listFiles();
        boolean isFileDeleted = false;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains(fileName)) {
                isFileDeleted = file.delete();
            }
        }
        return isFileDeleted;
    }

}
