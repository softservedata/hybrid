package com.softserve.edu.oms.data;

import java.sql.Driver;
import java.sql.SQLException;

import com.softserve.edu.atqc.tools.data.DataSource;
import com.softserve.edu.atqc.tools.exceptions.GeneralCustomException;

public final class DataSourceRepository {
    private final static String FAILED_JDBC_DRIVER = "Failed to create JDBC Driver";

    private DataSourceRepository() {
    }

    public static DataSource getJtdsMsSqlLocal() {
        return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
                "jdbc:jtds:sqlserver://CLASS02/Lv-157_OMS;instance=SQLEXPRESS;", "db157", "db157");
    }

    public static DataSource getJdbcMySqlLocal() {
        Driver jdbcDriver = null;
        try {
            jdbcDriver = new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            throw new GeneralCustomException(FAILED_JDBC_DRIVER, e);
        }
        return new DataSource(jdbcDriver,
                "jdbc:mysql://localhost:3306/measurement_devices;", "root", "root");
    }

    // TODO Read from properties

}
