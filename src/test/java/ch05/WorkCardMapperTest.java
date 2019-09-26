package ch05;

import ch03.utils.SqlSessionFactoryUtils;
import ch05.mapper.TaskMapper;
import ch05.mapper.WorkCardMapper;
import ch05.pojo.Task;
import ch05.pojo.WorkCard;
import org.apache.ibatis.session.SqlSession;

public class WorkCardMapperTest {

    private SqlSession sqlSession = null;
    private WorkCardMapper mapper = null;

    public WorkCardMapperTest(){
        sqlSession = SqlSessionFactoryUtils.openSqlSession();
        mapper = sqlSession.getMapper(WorkCardMapper.class);
    }

    public void testInsertWorkCard(WorkCard workCard){
        try{
            mapper.insert(workCard);
            sqlSession.commit();
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    public WorkCard testGetWorkCard(long id){
        WorkCard workCard = null;
        try{
            workCard = mapper.getById(id);
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return workCard;
    }


    public static void main(String[] args){
        WorkCardMapperTest test = new WorkCardMapperTest();
        WorkCard workCard = new WorkCard();
        workCard.setRealName("张三");
        workCard.setDepartment("设计部");
        workCard.setEmpId(1L);
        workCard.setMobile("13488888888");
        workCard.setNote("level 7");
        workCard.setPosition("广州");
        test.testInsertWorkCard(workCard);

        workCard = test.testGetWorkCard(1L);
        System.out.println(workCard);
    }
}
