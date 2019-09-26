package ch05.mapper;

import ch05.pojo.Task;

public interface TaskMapper {

    Task getById(Long id);
    void insert(Task task);

}
