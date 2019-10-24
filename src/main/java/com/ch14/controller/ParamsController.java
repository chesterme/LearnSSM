package com.ch14.controller;

import com.ch14.pojo.Param;
import com.ch14.pojo.RoleParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("paramsController")
@RequestMapping("/param")
public class ParamsController {

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

}
