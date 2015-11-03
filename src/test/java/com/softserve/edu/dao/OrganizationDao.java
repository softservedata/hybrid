package com.softserve.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.tools.data.ConnectionUtils;
import com.softserve.edu.atqc.tools.data.DataSource;
import com.softserve.edu.atqc.tools.exceptions.GeneralCustomException;
import com.softserve.edu.entity.OrganizationDB;
import com.softserve.edu.entity.OrganizationDB.OrganizationDBQueries;
import com.softserve.edu.entity.UserDB;


public class OrganizationDao {
	private final static String DATABASE_READING_ERROR = "Database Reading Error";
    private static volatile OrganizationDao instance = null;
    private DataSource dataSource;

    private OrganizationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static OrganizationDao get(DataSource dataSource) {
        if (instance == null) {
            synchronized (OrganizationDao.class) {
                if (instance == null) {
                    instance = new OrganizationDao(dataSource);
                }
            }
        }
        return instance;
    }
    
    public List<OrganizationDB> getAllOrganizations() {
        List<OrganizationDB> allOrganizations = new ArrayList<OrganizationDB>();
        Statement statement = null;
        ResultSet resultSet = null;
        String query = OrganizationDBQueries.GET_ALL_ORGANIZATIONS.toString();
        try {
            statement = ConnectionUtils.get(dataSource).getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // TODO Use Builder
            	allOrganizations.add(new OrganizationDB(Long.parseLong(resultSet.getString(1)), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),
                         Long.parseLong(resultSet.getString(11))));
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
        return allOrganizations;
    }
}
