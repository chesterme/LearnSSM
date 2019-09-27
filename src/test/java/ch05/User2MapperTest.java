package ch05;

import ch05.mapper.User2Mapper;
import ch05.pojo.User2;

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
        User2MapperTest test = new User2MapperTest();
        test.testGetById(1L);
        test.testGetByRoleId(1L);
    }

}
