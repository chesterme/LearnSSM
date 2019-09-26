package ch05.mapper;

import ch05.pojo.FemaleHealthForm;

public interface FemaleHealthFormMapper {

    void insert(FemaleHealthForm form);
    FemaleHealthForm getByEmpId(long id);

}
