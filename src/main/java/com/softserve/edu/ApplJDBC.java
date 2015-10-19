package com.softserve.edu;

import java.sql.Connection;
//import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplJDBC {
    private static Connection con = null;
     //private static String username = "db148";
    //private static String password = "db148";
    //private static String username = "lv-117";
    //private static String password = "lv-117";
    private static String username = "db157";
    private static String password = "db157";
    ////private static String username = "root";
    ///private static String password = "root";
    //private static String URL = "jdbc:sqlserver://streamer2005.softservecom.com/_097_Proba;instance=tc;";
    //private static String URL = "jdbc:sqlserver://CLASS02.training.local/CoolShop;instance=SQLEXPRESS;";
    //private static String URL = "jdbc:sqlserver://ssu-sql12/Lv117proba;instance=tc;";
    //private static String URL = "jdbc:sqlserver://CLASS02.training.local/CoolShop;instance=SQLEXPRESS";
//    private static String URL = "jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;";
    //private static String URL = "jdbc:jtds:sqlserver://CLASS02/CoolShop;instance=SQLEXPRESS;";
    private static String URL = "jdbc:jtds:sqlserver://CLASS02/Lv-157_OMS;instance=SQLEXPRESS;";
    ////private static String URL = "jdbc:mysql://localhost:3306/measurement_devices";
    
    public static void main(String[] args) throws SQLException {
        System.out.println("Start...");
        //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        // Load the driver
        con = DriverManager.getConnection(URL, username, password);
        if (con != null)
            System.out.println("Connection Successful! \n");
        if (con == null)
            System.exit(0);
        Statement st = con.createStatement();
        // Statement allows you to send inquiries database
        //ResultSet rs = st.executeQuery("select * from Users");
        //ResultSet rs = st.executeQuery("SELECT ID, Login, Password, FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users WHERE Login = 'aaai';");
        ResultSet rs = st.executeQuery("SELECT * FROM dbo.Users;");
        //ResultSet rs = st.executeQuery("SELECT *  FROM Users;");
        // ResultSet gets the result table
        int x = rs.getMetaData().getColumnCount();
        // Resultset.getMetaData () get the information
        // output file
        while (rs.next()) {
            for (int i = 1; i <= x; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if (rs != null)
            rs.close();
        if (st != null)
            st.close();
        if (con != null)
            con.close();
    }
}
