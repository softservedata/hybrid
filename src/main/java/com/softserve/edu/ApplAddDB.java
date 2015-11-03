package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class ApplAddDB {
    private static final String SELECT_USERNAME = "SELECT username FROM user WHERE username='%s';";
    private static final String INSERT_USER = "INSERT INTO user (username,isAvaliable,password,organization_organizationId) VALUES ('%s',1,'$2a$10$59Mv7tEUrVH8iBeDsm9y7.zUcJoPHnnyOvMnC4zKRV8.wlnugQ2G2',43);";
    private static final String INSERT_USERS_ROLES = "INSERT INTO users_roles (username,id) VALUES ('%s',6);";
    private static Connection connection = null;
    private static String username = "root";
    private static String password = "root";
    private static String URL = "jdbc:mysql://localhost:3306/measurement_devices";

    public static void main(String[] args) throws SQLException {
        Random random = new Random();
        String userName;
        int count = 0;
        Statement statement = null;
        ResultSet resultSet = null;
        //
        System.out.println("Start...");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(URL, username, password);
        if (connection != null) {
            System.out.println("Connection Successful! \n");
        } else {
            System.exit(0);
        }
        statement = connection.createStatement();
        //
        // ResultSet resultSet = statement.executeQuery("SELECT username FROM
        // user WHERE username='provider-lv4';");
        // if (resultSet.next()){
        // System.out.println("found");
        // } else {
        // System.out.println("NOT found");
        // }
        //
        for (int i = 0; i < 100; i++) {
            userName = "";
            for (int j = 0; j < 10; j++) {
                // System.out.print(String.valueOf((char)(random.nextInt(26)+97)));
                // System.out.print(String.valueOf(Character.toChars(random.nextInt(26)
                // + 97)));
                userName = userName + String.valueOf(Character.toChars(random.nextInt(26) + 97));
            }
            System.out.print("Generated: " + userName);
            //
            resultSet = statement.executeQuery(String.format(SELECT_USERNAME, userName));
            if (resultSet.next()) {
                System.out.println(" duplicate found, skipped.");
                continue;
            } else {
                System.out.println(" prepare to insert."+" Count #" + (++count));
            }
            //
            statement.execute(String.format(INSERT_USER, userName));
            statement.execute(String.format(INSERT_USERS_ROLES, userName));
        }
        //
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
