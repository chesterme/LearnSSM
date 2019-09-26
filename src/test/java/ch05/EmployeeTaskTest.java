package ch05;

import ch05.mapper.EmployeeTaskMapper;
import ch05.pojo.Employee;
import ch05.pojo.EmployeeTask;
import ch05.pojo.Task;

public class EmployeeTaskTest extends DefaultTest{

    private EmployeeTaskMapper mapper = null;

    public EmployeeTaskTest(){
        super();
        mapper = getSqlSession().getMapper(EmployeeTaskMapper.class);
    }

    public void testInsert(EmployeeTask task){
        try{
            mapper.insert(task);
            getSqlSession().commit();
        }finally{
            close();
        }
    }

    public EmployeeTask testGetById(long id){
        EmployeeTask task = null;
        try{
            task = mapper.getById(id);
        }finally{
            close();
        }
        return task;
    }

    public static void main(String[] args){
        EmployeeTaskTest test = new EmployeeTaskTest();
//        TaskMapperTest taskMapperTest = new TaskMapperTest();
//        Task task = taskMapperTest.testGetTask(1L);
//        EmployeeTask employeeTask = new EmployeeTask();
//        employeeTask.setEmpId(1l);
//        employeeTask.setNote("五天内完成");
//        employeeTask.setTask(task);
//        employeeTask.setTaskName("设计产品外观");
//        test.testInsert(employeeTask);
        EmployeeTask task = test.testGetById(1L);
        System.out.println(task);
    }

}
