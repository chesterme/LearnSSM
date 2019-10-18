package com.ch14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

// 指明一个控制器
@Controller("myController")
// 指明当前请求的URI在/my下时，该控制器才做响应
@RequestMapping("/my")
public class MyController {

    @Autowired
    private ServletContext servletContext;

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

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public ModelAndView file(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("get-file");
        return mv;
    }

    @RequestMapping(value = "/getFile", method = RequestMethod.GET)
    public void getFile(@RequestParam("filename") String filename, HttpServletResponse response){

//        String webRootPath = servletContext.getRealPath("");
        String basePath = "/WEB-INF/resources/";
        String filePath =  basePath + filename;
        String fileAbsolutePath = servletContext.getRealPath(filePath);
        int lastIndex = fileAbsolutePath.lastIndexOf(".");
        String flag = fileAbsolutePath.substring(lastIndex + 1);
        if(flag.equals("txt")){
            handleFile(fileAbsolutePath, response);
        }else if(flag.equals("xml")){
            response.setContentType("text/xml");
            handleFile(fileAbsolutePath, response);
        }
    }


    private void handleFile(String fileAbsolutePath, HttpServletResponse response){
        File file = new File(fileAbsolutePath);
        byte[] buffer = new byte[1024];
        int count = 0;
        FileInputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream(file);
            out = response.getOutputStream();
            while((count = in.read(buffer)) != -1){
                out.write(buffer, 0, count);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(in != null){
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(out != null){
                try{
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
