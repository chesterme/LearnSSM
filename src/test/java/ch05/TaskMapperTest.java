package ch05;

import ch03.utils.SqlSessionFactoryUtils;
import ch05.mapper.TaskMapper;
import ch05.pojo.Task;
import org.apache.ibatis.session.SqlSession;

public class TaskMapperTest {

    private SqlSession sqlSession = null;
    TaskMapper taskMapper = null;

    public TaskMapperTest(){
        sqlSession = SqlSessionFactoryUtils.openSqlSession();
        taskMapper = sqlSession.getMapper(TaskMapper.class);
    }

    public void testInsertTask(Task task){
        try{
            taskMapper.insert(task);
            sqlSession.commit();
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    public Task testGetTask(long id){
        return taskMapper.getById(id);
    }


    public static void main(String[] args){
        TaskMapperTest test = new TaskMapperTest();
        Task task = test.testGetTask(1L);
        System.out.println(task);
    }

}
