package com.ch14.controller;

import ch10.pojo.Role;
import com.ch14.pojo.PageParams;
import com.ch14.pojo.RoleParams;
import com.ch14.pojo.Test;
import com.ch14.service.RoleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

// 指明一个控制器
@Controller("myController")
// 指明当前请求的URI在/my下时，该控制器才做响应
@RequestMapping("/my")
public class MyController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private RoleService roleService;

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

        String basePath = "/WEB-INF/resources/";
        String filePath =  basePath + filename;
        // 获取资源文件的绝对路径
        String fileAbsolutePath = servletContext.getRealPath(filePath);
        int lastIndex = fileAbsolutePath.lastIndexOf(".");
        String flag = fileAbsolutePath.substring(lastIndex + 1);
        if(flag.equals("txt")){
            handleFile(fileAbsolutePath, response);
        }else if(flag.equals("xml")){
            response.setContentType("text/xml");
            handleFile(fileAbsolutePath, response);
        }else if(flag.equals("jpg")){
            response.setContentType("image/jpeg");
            handleFile(fileAbsolutePath, response);
        }else{
            handleFile(fileAbsolutePath, response);
        }
    }

    @RequestMapping("/getPictures")
    public void getPictures(@RequestParam("filename") String filename, HttpServletResponse response){
        getFile(filename, response);
    }

    @RequestMapping("/getPicture")
    public void getPicture(@RequestParam("filename") String filename, HttpServletResponse response){
        getFile(filename, response);
    }

    @RequestMapping("/picture")
    public ModelAndView handlePicture(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pictures");
        return mv;
    }

    @RequestMapping("/randomPicture")
    public ModelAndView handleRandomPicture(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("random-picture");
        return mv;
    }

    @RequestMapping("/blank")
    public ModelAndView handleBlank(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("blank");
        return mv;
    }

    @RequestMapping("/role")
    public ModelAndView pageToRole(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role");
        return mv;
    }


    @RequestMapping(value = "/handleRole", method = RequestMethod.GET)
    public void handleRole(HttpServletRequest request) throws UnsupportedEncodingException {
        String roleName = request.getParameter("role_name");
        String note = request.getParameter("note");
        String decodeRoleName = URLDecoder.decode(request.getParameter("role_name"), "utf-8");
        String decodeNote = URLDecoder.decode(request.getParameter("note"), "utf-8");
        System.out.println(roleName);
        System.out.println(note);
        System.out.println(decodeRoleName);
        System.out.println(decodeNote);

        if(roleName.equals(new String(roleName.getBytes(), "utf8"))){
            System.out.println("编码格式为: utf8");
        }
        else if (roleName.equals(new String(roleName.getBytes(), "gbk"))){
            System.out.println("编码格式为：gbk");
        }else{
            System.out.println("其他不常用的编码");
        }
    }

    // 使用RESTFul风格
    // {id}表示接受一个参数
    @RequestMapping("/getRole/{id}")
    // 注解@PathVariable表示从URL的请求地址中获取参数
    public ModelAndView getRoleById(@PathVariable(name = "id") Long id){
        Role role = roleService.getById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(role);
        // 设置视图为JSON视图
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/toFindRoles")
    public ModelAndView pageToFindRoles(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("find-role");
        return mv;
    }


    @RequestMapping(value = "/findRoles")
    public ModelAndView handleFindRoles(@RequestBody RoleParams roleParams){
        List<Role> roleList = roleService.findRoles(roleParams);
        ModelAndView mv = new ModelAndView();
        mv.addObject(roleList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    // 使用原生的request来获取请求内容
//    @RequestMapping(value = "/findRoles")
//    public ModelAndView handleFindRoles(HttpServletRequest request){
//        String result = "";
//        InputStream in = null;
//        byte[] buff = new byte[1024];
//        int count = 0;
//        List<Byte> bytes = new ArrayList<>();
//        try{
//            in = request.getInputStream();
//            while((count = in.read(buff)) != -1){
//                for(int i = 0; i < count; i ++){
//                    bytes.add(buff[i]);
//                }
//            }
//
//            byte[] input = new byte[bytes.size()];
//            for(int i = 0; i < input.length; i++){
//                input[i] = bytes.get(i);
//            }
//            result = new String(input, "utf8");
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            if(in != null){
//                try{
//                    in.close();
//                }catch(IOException ex){
//                    ex.printStackTrace();
//                }
//            }
//        }
//        System.out.println(result);
//
//        // 构建一个json对象
//        JSONObject jsonObject = new JSONObject(result);
//        RoleParams roleParams = new RoleParams();
//        roleParams.setNote((String)jsonObject.get("note"));
//        roleParams.setRoleName((String)jsonObject.get("roleName"));
//        JSONObject inner = jsonObject.getJSONObject("pageParams");
//        roleParams.setPageParams(new PageParams((int)inner.get("start"), (int)inner.get("limit")));
//        System.out.println(roleParams);
//
//        // 查询
//        List<Role> roles = new ArrayList<>();
//        roles = roleService.findRoles(roleParams);
//        for(int i = 0; i < roles.size(); i++){
//            System.out.println("roles[" + i + "]: " + roles.get(i));
//        }
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject(roles);
//        mv.setView(new MappingJackson2JsonView());
//        return mv;
//    }

    @RequestMapping(value = "/test")
    public ModelAndView handleTest(@RequestBody Test test){
        System.out.println(test);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(test);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
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
