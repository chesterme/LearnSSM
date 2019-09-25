package ch03.main;

import ch03.mapper.RoleMapper;
import ch03.pojo.Role;
import ch03.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args){

        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

}
