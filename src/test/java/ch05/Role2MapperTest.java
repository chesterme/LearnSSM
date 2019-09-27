package ch05;

import ch05.mapper.Role2Mapper;
import ch05.pojo.Role2;

import java.util.List;

public class Role2MapperTest extends DefaultTest {

    private Role2Mapper mapper = null;

    public Role2MapperTest(){
        mapper = getSqlSession().getMapper(Role2Mapper.class);
    }

    public Role2 testGetById(long id){
        Role2 role = null;
        role = mapper.getById(id);
        return role;
    }

    public List<Role2> testGetByUserId(long id) {
        List<Role2> roles = null;
        roles = mapper.getByUserId(id);
        return roles;
    }

    public static void main(String[] args){

        Role2MapperTest test = new Role2MapperTest();
        Role2 role = test.testGetById(1L);
        List<Role2> roles = test.testGetByUserId(1L);
        test.close();
    }

}
