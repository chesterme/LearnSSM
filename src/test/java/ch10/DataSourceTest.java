package ch10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;

public class DataSourceTest {

    public static void main(String[] args) {

        ApplicationContext act = new ClassPathXmlApplicationContext("ch10/config/Beans.xml");
//        DataSource dataSource = (DataSource) act.getBean("dataSource");
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            con = dataSource.getConnection();
//            String sql = "SELECT name,age,picture FROM t_animal WHERE name like concat('%', 'TheCat', '%')";
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                String name = rs.getString(1);
//                int age = rs.getInt(2);
//
//                Blob picture = rs.getBlob(3); //得到Blob对象
//                //开始读入文件
//                InputStream in = picture.getBinaryStream();
//                OutputStream out = new FileOutputStream("outputCat.jpg");
//                byte[] buffer = new byte[1024];
//                int len = 0;
//                while ((len = in.read(buffer)) != -1) {
//                    out.write(buffer, 0, len);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
