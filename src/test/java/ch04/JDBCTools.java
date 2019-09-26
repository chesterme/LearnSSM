package ch04;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCTools {

    public static Connection getConnection() throws Exception{//连接数据库
        String driverClass = null;
        String url = null;
        String user = null;
        String password = null;

        Properties properties = new Properties();

        InputStream in = Review.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(in);

        driverClass = properties.getProperty("database.driver");
        url = properties.getProperty("database.url");
        user = properties.getProperty("database.username");
        password = properties.getProperty("database.password");
        Class.forName(driverClass);
        return DriverManager.getConnection(url, user, password);
    }

    public static void release(Connection con , Statement state){//关闭数据库连接
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void release(ResultSet rs , Connection con , Statement state){//关闭数据库连接
        if(rs != null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
