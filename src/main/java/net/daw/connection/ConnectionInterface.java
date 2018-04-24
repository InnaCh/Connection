package net.daw.connection;

import java.sql.Connection;

public interface ConnectionInterface {

    public Connection newConnection() throws Exception;

    public void disposeConnection() throws Exception;
}
