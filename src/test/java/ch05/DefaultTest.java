package ch05;

import ch03.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;

public class DefaultTest implements Serializable {

    private static final long serialVersionUID = -6663311294451250240L;
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
