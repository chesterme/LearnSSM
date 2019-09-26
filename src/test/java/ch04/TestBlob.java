package ch04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestBlob {

    public void getBlob(){//读取Blob数据
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCTools.getConnection();
            String sql = "SELECT name,age,picture FROM t_animal WHERE name like concat('%', 'TheCat', '%')";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString(1);
                int age = rs.getInt(2);

                Blob picture = rs.getBlob(3); //得到Blob对象
                //开始读入文件
                InputStream in = picture.getBinaryStream();
                OutputStream out = new FileOutputStream("outputCat.jpg");
                byte[] buffer = new byte[1024];
                int len = 0;
                while((len = in.read(buffer)) != -1){
                    out.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertBlob(){//插入Blob
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCTools.getConnection();
            String sql = "INSERT INTO t_animal(name,age,picture) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "TheCat");
            ps.setInt(2, 8);
            InputStream in = new FileInputStream("cat.jpg");//生成被插入文件的节点流
            //设置Blob
            ps.setBlob(3, in);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCTools.release(con, ps);
        }
    }

    public static void main(String[] args){
        TestBlob test = new TestBlob();
//        test.insertBlob();
        test.getBlob();
    }

}
