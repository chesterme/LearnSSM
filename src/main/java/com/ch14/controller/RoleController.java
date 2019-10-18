package com.ch14.controller;

import ch10.pojo.Role;
import com.ch14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller("roleController")
@RequestMapping("/role")
public class RoleController {

    // 注入角色
    @Autowired
    private RoleService roleService = null;

    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public ModelAndView getRole(@RequestParam("id") long id){
        Role role = roleService.getById(id);
        ModelAndView mv = new ModelAndView();
        // 给数据模型添加一个对象
        mv.addObject("role", role);
//        mv.setViewName("role-details");
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

}
