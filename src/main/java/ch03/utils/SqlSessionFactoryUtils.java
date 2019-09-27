package ch03.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * 一个工具类，用于创建SqlSessionFactory和获取SqlSession对象
 */
public class SqlSessionFactoryUtils implements Serializable {

    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
    private static final long serialVersionUID = -237185279116689793L;
    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryUtils(){}

    /**
     * 使用单例的方式创建SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized(LOCK){
            if(sqlSessionFactory != null){
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream in;
            try{
                in = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

}
