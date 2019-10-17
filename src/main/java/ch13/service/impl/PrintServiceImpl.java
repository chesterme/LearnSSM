package ch13.service.impl;

import ch13.mapper.RoleMapper;
import ch13.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("printServiceImpl")
public class PrintServiceImpl implements PrintService {

    @Autowired
    private RoleMapper roleMapper = null;

    @Override
    public void print() {
        System.out.println(roleMapper.getById(1));
    }
}
