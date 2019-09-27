package ch05.mapper;

import ch05.pojo.User2;

import java.util.List;

public interface User2Mapper {
    User2 getById(long id);
    List<User2> getByRoleId(long id);
}
