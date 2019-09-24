package ch03;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryTest {

    public static void main(String[] args) throws IOException {

        SqlSessionFactory sqlSessionFactory = null;

        String resource = "mybatis-config.xml";
        InputStream in;
        try{
            in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
