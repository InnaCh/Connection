
package net.daw.connection;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import net.daw.helper.ConnectionClassHelper;
import net.daw.helper.Log4jConfigurationHelper;

public class HikariConnection implements ConnectionInterface {

    private HikariDataSource oConnectionPool = null;
    private Connection oConnection = null;

    @Override
    public Connection newConnection() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(ConnectionClassHelper.getConnectionChain());
        config.setUsername(ConnectionClassHelper.getDatabaseLogin());
        config.setPassword(ConnectionClassHelper.getDatabasePassword());
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setLeakDetectionThreshold(15000);
        config.setConnectionTestQuery("SELECT 1");
        config.setConnectionTimeout(2000);
        try {
            oConnectionPool = new HikariDataSource(config);
            oConnection = oConnectionPool.getConnection();
        } catch (SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return oConnection;
    }

    @Override
    public void disposeConnection() throws Exception {
        try {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oConnectionPool != null) {
                oConnectionPool.close();
            }
        } catch (SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jConfigurationHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }
}
