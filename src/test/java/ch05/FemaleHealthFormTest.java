package ch05;

import ch05.mapper.FemaleHealthFormMapper;
import ch05.pojo.FemaleHealthForm;

public class FemaleHealthFormTest extends DefaultTest {

    private FemaleHealthFormMapper mapper = null;

    public FemaleHealthFormTest(){
        super();
        mapper = getSqlSession().getMapper(FemaleHealthFormMapper.class);
    }

    public void testInsert(FemaleHealthForm femaleHealthForm){
        try{
            mapper.insert(femaleHealthForm);
            getSqlSession().commit();
        }finally{
            close();
        }
    }

    public FemaleHealthForm testGetByEmpId(long id){
        FemaleHealthForm femaleHealthForm = null;
        try{
            femaleHealthForm = mapper.getByEmpId(id);
        }finally{
            close();
        }
        return femaleHealthForm;
    }

    public static void main(String[] args){
        FemaleHealthFormTest test = new FemaleHealthFormTest();
        FemaleHealthForm femaleHealthForm = new FemaleHealthForm();
//        femaleHealthForm.setEmpId(2L);
//        femaleHealthForm.setUterus("健康");
//        femaleHealthForm.setHeart("健康");
//        femaleHealthForm.setKidney("健康");
//        femaleHealthForm.setLiver("健康");
//        femaleHealthForm.setLung("健康");
//        femaleHealthForm.setNote("整体健康");
//        femaleHealthForm.setSpleen("健康");
//        test.testInsert(femaleHealthForm);
        femaleHealthForm = test.testGetByEmpId(2L);
    }

}
