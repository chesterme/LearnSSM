package ch04.main;

import ch03.utils.SqlSessionFactoryUtils;
import ch04.mapper.UserMapper;
import ch04.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args){

        Logger log = Logger.getLogger(ch03.main.Main.class);
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1L);
            log.info(user.getSex().getName());
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }

    }

}
