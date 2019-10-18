package com.ch14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

// 指明一个控制器
@Controller("myController")
// 指明当前请求的URI在/my下时，该控制器才做响应
@RequestMapping("/my")
public class MyController {

    // 表明URI是/index的时候该方法，才调用该方法
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public ModelAndView index2(@RequestParam(value = "id") long id){
        System.out.println("params[id] = " + id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/index3", method = RequestMethod.GET)
    public ModelAndView index3(@SessionAttribute("username") String username){
        System.out.println("session[username] = " + username);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
