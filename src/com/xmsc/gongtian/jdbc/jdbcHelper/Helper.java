package com.xmsc.gongtian.jdbc.jdbcHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//120.79.160.200
public class Helper {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_xmsc" +
            "?characterEncoding=utf8&useSSL=false";
    private static final String USR = "root";
    private static final String PWD = "root";

    static {
        try{
            Class.forName(DRIVER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,USR,PWD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection,PreparedStatement ps){
        close(connection,ps,null);
    }

    public static void close(Connection connection, PreparedStatement ps, ResultSet rs){
        try{
            if(connection != null){
                connection.close();
            }
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
