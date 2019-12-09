package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static Logger Log = LogManager.getRootLogger();

    public static void startTestCase(String testCaseName) {
        Log.info("******************************************************");
        Log.info("$$                 " + testCaseName + "       $$");
        Log.info("******************************************************");
    }

    public static void endTestCase(String testCaseName) {
        Log.info("******************************************************");
        Log.info("$$                 " + "END" + testCaseName + "Test Case "+ "       $$");
        Log.info("******************************************************");
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    public static void fatal(String message) {
        Log.fatal(message);
    }

    public static void debug(String message) {
        Log.debug(message);
    }
}