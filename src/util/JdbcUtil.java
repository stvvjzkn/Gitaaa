package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtil{
    private static ResourceBundle bundle;
    static{
        //获取src下的properties
        bundle=ResourceBundle.getBundle("db");
    }

    public static Connection getConn(){
        Connection conn=null;
        try {
            Class.forName(bundle.getString("driver"));
            conn = DriverManager.getConnection(bundle.getString("url"),
                    bundle.getString("username"), bundle.getString("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
}
