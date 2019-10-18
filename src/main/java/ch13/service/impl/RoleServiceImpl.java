package ch13.service.impl;

import ch10.pojo.Role;
import ch10.pojo.Role;
import ch13.service.RoleService;
import ch13.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Component(value = "roleServiceImpl")
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper = null;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public void deleteById(long id) {
        roleMapper.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public Role getById(long id) {
        return roleMapper.getById(id);
    }
}
