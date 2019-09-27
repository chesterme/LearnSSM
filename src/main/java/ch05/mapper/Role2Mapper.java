package ch05.mapper;

import ch05.pojo.Role2;

import java.util.List;

public interface Role2Mapper {

//    void insert(Role2 role);
    Role2 getById(long id);
    List<Role2> getByUserId(long id);

}
