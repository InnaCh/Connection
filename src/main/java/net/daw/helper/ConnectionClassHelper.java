package net.daw.helper;

public class ConnectionClassHelper {

    public static String getDatabaseName() {
        return "trolleyes";
    }

    public static String getDatabaseLogin() {
        return "root";
    }

    public static String getDatabasePassword() {
        return "225524";
    }

    public static String getDatabasePort() {
        return "3306";
    }

    public static String getDatabaseIP() {
        return "localhost";
    }

    public static String getConnectionChain() {
        return "jdbc:mysql://" + ConnectionClassHelper.getDatabaseIP() + ":" + ConnectionClassHelper.getDatabasePort() + "/" + ConnectionClassHelper.getDatabaseName();
    }

}
