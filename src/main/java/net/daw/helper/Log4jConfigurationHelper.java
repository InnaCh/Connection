
package net.daw.helper;

import org.apache.log4j.Logger;

public class Log4jConfigurationHelper {

    public static void infoLog(String strMessage) {
        Logger log = Logger.getLogger("connection-server");
        log.info(strMessage);
    }

    public static void errorLog(String strMessage) {
        Logger log = Logger.getLogger("connection-server");
        log.error(strMessage);
    }

    public static void errorLog(String strMessage, Exception ex) {
        Logger log = Logger.getLogger("connection-server");
        log.error(strMessage, ex);
    }

    public static void fatalLog(String strMessage) {
        Logger log = Logger.getLogger("connection-server");
        log.fatal(strMessage);
    }

    public static void debugLog(String strMessage) {
        Logger log = Logger.getLogger("connection-server");
        log.debug(strMessage);
    }

    public static void warnLog(String strMessage) {
        Logger log = Logger.getLogger("connection-server");
        log.warn(strMessage);
    }

}
