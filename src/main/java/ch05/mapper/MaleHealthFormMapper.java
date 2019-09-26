package ch05.mapper;

import ch05.pojo.MaleHealthForm;

public interface MaleHealthFormMapper {

    void insert(MaleHealthForm healthForm);
    MaleHealthForm getByEmpId(long id);

}
