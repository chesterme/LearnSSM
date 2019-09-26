package ch05.mapper;

import ch05.pojo.EmployeeTask;

public interface EmployeeTaskMapper {

    EmployeeTask getById(long id);
    void insert(EmployeeTask task);

}
