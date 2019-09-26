package ch05.mapper;

import ch05.pojo.Employee;

public interface EmployeeMapper {
    void insert(Employee employee);
    Employee getById(long id);
}
