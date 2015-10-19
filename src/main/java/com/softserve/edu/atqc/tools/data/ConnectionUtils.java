package com.softserve.edu.atqc.tools.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.softserve.edu.atqc.tools.exceptions.GeneralCustomException;

public class ConnectionUtils {
    private final static String FAILED_REGISTRATE_DRIVER = "Failed to Registrate JDBC Driver";
    private static volatile ConnectionUtils instance = null;
    // TODO multithreading
    private Connection connection = null;
    private DataSource dataSource;

    private ConnectionUtils(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ConnectionUtils get(DataSource dataSource) {
        if (instance == null) {
            synchronized (ConnectionUtils.class) {
                if (instance == null) {
                    instance = new ConnectionUtils(dataSource);
                    try {
                        DriverManager.registerDriver(dataSource.getJdbcDriver());
                    } catch (SQLException e) {
                        throw new GeneralCustomException(FAILED_REGISTRATE_DRIVER, e);
                    }
                }
            }
        }
        return instance;
    }

    public static ConnectionUtils get() {
        if (instance == null) {
            throw new GeneralCustomException(FAILED_REGISTRATE_DRIVER);
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            synchronized (ConnectionUtils.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(dataSource.getUrl(),
                                dataSource.getUsername(), dataSource.getPassword());
                    } catch (SQLException e) {
                        throw new GeneralCustomException(FAILED_REGISTRATE_DRIVER, e);
                    }
                }
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (getConnection() != null) {
            try {
                getConnection().close();
            } catch (SQLException e) {
                throw new GeneralCustomException(FAILED_REGISTRATE_DRIVER, e);
            }
        }
    }

}
