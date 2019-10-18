package ch13.service.impl;

import ch10.pojo.Role;
import ch13.service.RoleListService;
import ch13.service.RoleService;
import ch10.pojo.Role;
import ch13.service.RoleListService;
import ch13.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleListServiceImpl implements RoleListService {

    @Autowired
    private RoleService roleService = null;
    private static Logger logger = Logger.getLogger(RoleListServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int insertRoleList(List<Role> roleList) {
        int count = 0;
        for(Role role : roleList){
            try{
                count += roleService.insertRole(role);
            }catch (Exception e){
                logger.info(e);
            }
        }
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int deleteRoleList(List<Role> roleList) {
        int count = 0;
        for(Role role : roleList){
            try{
                roleService.deleteById(role.getId());
                count++;
            }catch (Exception e){
                logger.info(e);
            }
        }
        return count;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public List<Role> selectRoleList(List<Long> intList) {
        List<Role> roleList = new ArrayList<>();
        for(int i = 0; i < intList.size(); i++){
            roleList.add(roleService.getById(intList.get(i)));
        }
        return roleList;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public void updateRoleList(List<Role> roleList) {
        for(Role role : roleList){
            roleService.update(role);
        }
    }
}
