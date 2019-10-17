package ch13.service;

import ch10.pojo.Role;

import java.util.List;

public interface RoleListService {

    int insertRoleList(List<Role> roleList);
    int deleteRoleList(List<Role> roleList);
    List<Role> selectRoleList(List<Long> intList);
    void updateRoleList(List<Role> roleList);

}
