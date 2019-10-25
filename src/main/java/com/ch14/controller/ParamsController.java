package com.ch14.controller;

import ch10.pojo.Role;
import com.ch14.pojo.Param;
import com.ch14.pojo.RoleParams;
import com.ch14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Controller("paramsController")
@RequestMapping("/param")
public class ParamsController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/test")
    public ModelAndView pageToTest(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("test");
        return mv;
    }

    @RequestMapping("/commonParamPojo1")
    public ModelAndView commonParamPojo1(@RequestParam("roleName") String roleName, @RequestParam("note") String note){
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/commonParamPojo2")
    public ModelAndView commonParamPojo2(@RequestBody List<Param> params){
        RoleParams roleParams = new RoleParams();

        for(int i = 0; i < params.size(); i++){
            Param temp = params.get(i);
            if(temp.getName().equals("roleName")){
                roleParams.setRoleName(temp.getValue());
            }
            else if(temp.getName().equals("note")){
                roleParams.setNote(temp.getValue());
            }
        }

        System.out.println("roleName => " + roleParams.getRoleName());
        System.out.println("note => " + roleParams.getNote());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/commonParamPojo3")
    public ModelAndView commonParamPojo3(@RequestBody RoleParams roleParams){
        System.out.println("roleName => " + roleParams.getRoleName());
        System.out.println("note => " + roleParams.getNote());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping("/pageToDelete")
    public ModelAndView pageToDelete(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("delete-role");
        return mv;
    }

    @RequestMapping("/pageToInsert")
    public ModelAndView pageToInsert(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("insert-role");
        return mv;
    }

    @RequestMapping("/pageToAdd")
    public ModelAndView pageToAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add-role");
        return mv;
    }

    @RequestMapping("/deleteRoles")
    public ModelAndView deleteRole(@RequestBody List<Long> idList){
        ModelAndView mv = new ModelAndView();
        int total = 0;
        for(int i = 0; i < idList.size(); i++){
           total += roleService.deleteById(idList.get(i));
        }
        mv.addObject("total", total);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/insertRoles")
    public ModelAndView insertRoles(@RequestBody List<Role> roleList){
        ModelAndView mv = new ModelAndView();
        int total = roleService.insertRoles(roleList);
        mv.addObject("total", total);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/addRole")
    public String addRoles(Model model, @RequestParam("roleName") String roleName, @RequestParam("note") String note){
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);

        ModelAndView mv = new ModelAndView();
        Role role = new Role(roleName, note);
        int total = roleService.insertRole(role);
        mv.addObject("total", total);

        // 绑定重定向数据模型
        model.addAttribute("roleName", role.getRoleName());
        model.addAttribute("note", role.getNote());
        model.addAttribute("id", role.getId());
        return "redirect: ./showRole.do";
    }

    @RequestMapping("/showRole")
    public ModelAndView showRole(String roleName, String note, long id){
        ModelAndView mv = new ModelAndView();
        Role role = new Role(id, roleName, note);
        mv.setView(new MappingJackson2JsonView());
        mv.addObject(role);
        return mv;
    }

    @RequestMapping("/addRole2")
    public String addRoles2(RedirectAttributes redirectAttributes, @RequestParam("roleName") String roleName, @RequestParam("note") String note){
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);

        Role role = new Role(roleName, note);
        int total = roleService.insertRole(role);
        System.out.println("role: " + role);

        // 往session中写入一个对象
        redirectAttributes.addFlashAttribute("role", role);
        return "redirect: ./showRole2.do";
    }


    @RequestMapping("/showRole2")
    public ModelAndView showRole2(Role role){
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject(role);
        return mv;
    }

}
