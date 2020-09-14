package util;

import org.junit.Test;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.function.Predicate;

public class DBUtil {
    public static Properties properties = new Properties();
    public static String driver;
    public static String url;
    public static String username;
    public static String password;
    static {
        try {
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        Connection connection = null;
        //1 加载驱动
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            // System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        if(conn!=null){
            ps.close();
        }

    }


}
