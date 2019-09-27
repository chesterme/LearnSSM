package ch05;

import ch03.utils.SqlSessionFactoryUtils;
import ch05.mapper.User2Mapper;
import ch05.pojo.User2;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class User2MapperTest extends DefaultTest {

    private User2Mapper mapper = null;

    public User2MapperTest(){
        mapper = getSqlSession().getMapper(User2Mapper.class);
    }

    public User2 testGetById(long id){
        User2 user = mapper.getById(id);
        return user;
    }

    public List<User2> testGetByRoleId(long id){
        List<User2> users = mapper.getByRoleId(id);
        return users;
    }

    public static void main(String[] args){
//        User2MapperTest test = new User2MapperTest();
//        test.testGetById(1L);
//        test.testGetById(1L);
//        test.testGetByRoleId(1L);

        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        SqlSession sqlSession1 = SqlSessionFactoryUtils.openSqlSession();
        User2Mapper mapper = sqlSession.getMapper(User2Mapper.class);
        User2Mapper mapper2 = sqlSession1.getMapper(User2Mapper.class);
        try{
            mapper.getById(1L);
            sqlSession.commit();
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        try{
            mapper2.getById(1L);
            sqlSession1.commit();
        }finally {
            if(sqlSession1 != null){
                sqlSession1.close();
            }
        }
    }

}
