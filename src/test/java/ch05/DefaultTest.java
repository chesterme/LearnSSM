package ch05;

import ch03.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class DefaultTest {

    private SqlSession sqlSession = null;

    public DefaultTest(){
        sqlSession = SqlSessionFactoryUtils.openSqlSession();
    }

    public void close(){
        if(sqlSession != null){
            sqlSession.close();
        }
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }
}
