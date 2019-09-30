package ch12.tradition;

import java.sql.*;

public class ConnectionUtil {

    public static Connection getConnection(){
        Connection con = null;
        try{
            // 注册驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            String userName = "test";
            String url = "jdbc:mysql://localhost:3306/ssm?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            String password = "123456";
            con = DriverManager.getConnection(url, userName, password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        try{
            if(rs != null && !rs.isClosed()){
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            if(ps != null && !ps.isClosed()){
                ps.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        try{
            if(con != null && !con.isClosed()){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
