package ch04.main;

import ch03.utils.SqlSessionFactoryUtils;
import ch04.mapper.FileMapper;
import ch04.mapper.UserMapper;
import ch04.pojo.TestFile;
import ch04.pojo.User;
import com.sun.org.apache.bcel.internal.generic.IFLE;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.*;

public class Main {

    public static void main(String[] args){

        Logger log = Logger.getLogger(ch03.main.Main.class);
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            User user = userMapper.getUser(1L);
//            log.info(user.getSex().getName());


            FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
            TestFile file = new TestFile();

            // 测试往数据库中写入图片
            FileInputStream in = new FileInputStream(new File("cat.jpg"));
            byte[] content = new byte[in.available()];
            in.read(content);
            file.setContent(content);
            fileMapper.insertFile(file);
            sqlSession.commit();


            // 测试从数据库中获取图片
//            file = fileMapper.getFile(28L);
//            File output = new File("output.jpg");
//            if(!output.exists()){
//                output.createNewFile();
//            }
//            FileOutputStream out = new FileOutputStream(output);
//            out.write(file.getContent());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }

    }

}
