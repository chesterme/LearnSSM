package ch04;

import ch03.mapper.RoleMapper;
import ch03.pojo.Role;
import ch03.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class MyObjectFactoryTest {

    public static void main(String[] args){

        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(1L);
        System.out.println(role.getRoleName());

    }

}
