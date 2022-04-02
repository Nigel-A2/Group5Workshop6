package com.group5.workshop6.group5workshop6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


class ConnectionManager {
    /**
     * Opens a connection to the database
     * @return The database connection, or null if the connection could not be established
     * */
    static Connection getConnection() {
        ConnectionInfo connInfo = getConnectionInfo("connection.properties");

        if (connInfo == null)
            return null;

        try {
            return DriverManager.getConnection(connInfo.getConnectionString(), connInfo.getUsername(), connInfo.getPassword());
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Retrieves the connection info from a .properties resource file
     * @param fileName The .properties file to load
     * @return The connection info record generated from the file
     * */
    private static ConnectionInfo getConnectionInfo(String fileName) {
        InputStream iStream = ConnectionManager.class.getResourceAsStream(fileName);
        if (iStream == null)
            return null;

        Properties props = new Properties();

        try {
            props.load(new BufferedReader(new InputStreamReader(iStream)));
        } catch (IOException e) {
            return null;
        }

        String dbProcotol = props.getProperty("dbProtocol");
        String host = props.getProperty("host");
        String port = props.getProperty("port");
        String db = props.getProperty("db");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        return new ConnectionInfo(dbProcotol, host, port, db, user, password);
    }
}
