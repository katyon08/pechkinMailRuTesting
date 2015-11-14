package loggers;

import org.apache.log4j.Logger;

public class LoggerOperator {

    private static Logger logger;

    public static void createLogger() {
        if (logger == null) {
            System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
            logger = Logger.getLogger(LoggerOperator.class);
        }
    }

    public static Logger getLogger() {
        createLogger();
        return logger;
    }
}
