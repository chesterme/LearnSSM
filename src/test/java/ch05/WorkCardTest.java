package ch05;

import ch05.mapper.WorkCardMapper;
import ch05.pojo.Employee;
import ch05.pojo.WorkCard;

public class WorkCardTest extends DefaultTest {

    private WorkCardMapper mapper = null;

    public WorkCardTest() {
        super();
        mapper = getSqlSession().getMapper(WorkCardMapper.class);
    }

    public void testInsert(WorkCard workCard){
        try{
            mapper.insert(workCard);
            getSqlSession().commit();
        }finally{
            close();
        }
    }

    public WorkCard testGetById(long id){
        WorkCard workCard = null;
        try{
            workCard = mapper.getById(id);
        }finally {
            close();
        }
        return workCard;
    }

    public static void main(String[] args){

        WorkCardTest test = new WorkCardTest();
        WorkCard workCard = new WorkCard();

//        EmployeeMapperTest employeeMapperTest = new EmployeeMapperTest();
//        Employee employee = employeeMapperTest.testSelect(1L);
//
//        workCard.setEmpId(employee.getId());
//        workCard.setPosition(employee.getPosition());
//        workCard.setNote("若捡到，请联系：" + employee.getMobile());
//        workCard.setMobile(employee.getMobile());
//        workCard.setDepartment("设计部");
//        workCard.setRealName(employee.getRealName());
//        test.testInsert(workCard);

        workCard = test.testGetById(1L);
        System.out.println(workCard);
    }
}
