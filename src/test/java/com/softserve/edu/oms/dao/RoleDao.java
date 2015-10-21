package com.softserve.edu.oms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.tools.data.ConnectionUtils;
import com.softserve.edu.atqc.tools.data.DataSource;
import com.softserve.edu.atqc.tools.exceptions.GeneralCustomException;
import com.softserve.edu.oms.entity.RoleDB;
import com.softserve.edu.oms.entity.RoleDB.RoleDBQueries;

public final class RoleDao {
    private final static String DATABASE_READING_ERROR = "Database Reading Error";
    private static volatile RoleDao instance = null;
    private DataSource dataSource;

    private RoleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static RoleDao get(DataSource dataSource) {
        if (instance == null) {
            synchronized (RoleDao.class) {
                if (instance == null) {
                    instance = new RoleDao(dataSource);
                }
            }
        }
        return instance;
    }

    // TODO Develop get() {}
    
    public RoleDB getRoleById(long id) {
        RoleDB role = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = String.format(RoleDBQueries.GET_ROLE_BY_ID.toString(), id);
        try {
            statement = ConnectionUtils.get(dataSource).getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                // TODO Use Builder
                role = new RoleDB(Long.parseLong(resultSet.getString(1)), resultSet.getString(2));
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new GeneralCustomException(DATABASE_READING_ERROR, e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    // TODO Warning
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Warning
                }
            }
        }
        return role;
    }

    public List<RoleDB> getAllRoles() {
        List<RoleDB> allRoles = new ArrayList<RoleDB>();
        Statement statement = null;
        ResultSet resultSet = null;
        String query = RoleDBQueries.GET_ALL_ROLES.toString();
        try {
            statement = ConnectionUtils.get(dataSource).getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // TODO Use Builder
                allRoles.add(new RoleDB(Long.parseLong(resultSet.getString(1)), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            throw new GeneralCustomException(DATABASE_READING_ERROR, e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    // TODO Warning
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Warning
                }
            }
        }
        return allRoles;
    }

}
