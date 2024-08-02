package cucumber.util;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Utils {

    private static final String DOWNLOAD_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";

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
        File folder = new File(DOWNLOAD_PATH);
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
        File folder = new File(DOWNLOAD_PATH);
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

    public static String convertMillisToString(long milliseconds) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        long seconds = (TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60);
        return minutes + " min " + seconds + " sec";
    }

    public static void retryOperation(Runnable operation, long timeoutMillis) {
        String errorMessage;
        long startTime = System.currentTimeMillis();

        do {
            try {
                operation.run();
                return;
            } catch (Throwable e) {
                errorMessage = e.getMessage();
            }
        } while (System.currentTimeMillis() - startTime < timeoutMillis);

        if (System.currentTimeMillis() - startTime >= timeoutMillis) {
            throw new Error("Operation failed to complete within " + convertMillisToString(timeoutMillis) + ". Error: " + errorMessage);
        }
    }

    public static void retryOperationWithCatch(Runnable operation1, Runnable operation2, long timeoutMillis) {
        String errorMessage;
        long startTime = System.currentTimeMillis();

        do {
            try {
                operation1.run();
                return;
            } catch (Throwable e) {
                errorMessage = e.getMessage();
                operation2.run();
            }
        } while (System.currentTimeMillis() - startTime < timeoutMillis);

        if (System.currentTimeMillis() - startTime >= timeoutMillis) {
            throw new Error("Operation failed to complete within " + convertMillisToString(timeoutMillis) + ". Error: " + errorMessage);
        }
    }

}
