
package net.daw.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.daw.connection.ConnectionInterface;
import net.daw.connection.HikariConnection;


public class AppConfigurationHelper {

    public static int getJsonMsgDepth() {
        return 1;
    }

    public static ConnectionInterface getSourceConnection() throws Exception {
        ConnectionInterface oDataConnectionSource = new HikariConnection();
        return oDataConnectionSource;
    }

    public static Gson getGson() throws Exception {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("dd/MM/yyyy HH:mm");
        Gson oGson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
        return oGson;
    }
}
