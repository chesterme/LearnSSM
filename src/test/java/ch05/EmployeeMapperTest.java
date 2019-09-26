package ch05;

import ch03.utils.SqlSessionFactoryUtils;
import ch04.SexEnum;
import ch05.mapper.EmployeeMapper;
import ch05.pojo.Employee;
import ch05.pojo.WorkCard;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class EmployeeMapperTest {

    private SqlSession sqlSession = null;
    private EmployeeMapper mapper = null;

    public EmployeeMapperTest(){
        sqlSession = SqlSessionFactoryUtils.openSqlSession();
        mapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    private void close(){
        if(sqlSession != null){
            sqlSession.close();
        }
    }

    public void testInsert(Employee employee){
        try{
            mapper.insert(employee);
            sqlSession.commit();
        }finally{
            close();
        }
    }

    public Employee testSelect(long id){
        Employee employee = null;
        try{
            employee = mapper.getById(id);
        }finally {
            close();
        }
        return employee;
    }

    public static void main(String[] args){

        Employee employee = new Employee();
        EmployeeMapperTest test = new EmployeeMapperTest();
//        employee.setBirthday(new Date());
//        employee.setEmail("xiaoming@163.com");
//        employee.setRealName("小明");
//        employee.setPosition("广州");
//        employee.setMobile("13488888888");
//        employee.setSex(SexEnum.MALE);
//        employee.setNote("喜欢篮球");
//        test.testInsert(employee);

        employee = test.testSelect(1L);
        System.out.println(employee);
    }

}
