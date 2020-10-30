package com.demo.util.db;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * date: 2018/10/26
 * author: fu jia xing  161250025
 */
public class DBUtils {

    //数据库连接地址
    public static String URL;
    //用户名
    public static String USERNAME;
    //密码
    public static String PASSWORD;
    //mysql的驱动类
    public static String DRIVER;

  //  private static ResourceBundle rb = ResourceBundle.getBundle("com.demo.util.db.db-config");

    private DBUtils() {
    }

    //使用静态块加载驱动程序
    static {
        URL = "jdbc:mysql://localhost:3306/expr?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
        USERNAME = "root";
        PASSWORD = "161250049";
        DRIVER = "com.mysql.jdbc.Driver";
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (stat != null) stat.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}