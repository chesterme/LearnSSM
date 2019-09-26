package ch05;

import ch05.mapper.FemaleHealthFormMapper;
import ch05.mapper.MaleHealthFormMapper;
import ch05.pojo.FemaleHealthForm;
import ch05.pojo.MaleHealthForm;

public class MaleHealthFormTest extends DefaultTest {

    private MaleHealthFormMapper mapper = null;

    public MaleHealthFormTest(){
        super();
        mapper = getSqlSession().getMapper(MaleHealthFormMapper.class);
    }

    public void testInsert(MaleHealthForm maleHealthForm){
        try{
            mapper.insert(maleHealthForm);
            getSqlSession().commit();
        }finally{
            close();
        }
    }

    public MaleHealthForm testGetByEmpId(long id){
        MaleHealthForm maleHealthForm = null;
        try{
            maleHealthForm = mapper.getByEmpId(id);
        }finally{
            close();
        }
        return maleHealthForm;
    }

    public static void main(String[] args){
        MaleHealthFormTest test = new MaleHealthFormTest();
        MaleHealthForm maleHealthForm = new MaleHealthForm();
//        maleHealthForm.setEmpId(1L);
//        maleHealthForm.setProstate("健康");
//        maleHealthForm.setHeart("健康");
//        maleHealthForm.setKidney("健康");
//        maleHealthForm.setLiver("健康");
//        maleHealthForm.setLung("健康");
//        maleHealthForm.setNote("整体健康");
//        maleHealthForm.setSpleen("健康");
//        test.testInsert(maleHealthForm);
        maleHealthForm = test.testGetByEmpId(1L);
    }

}
