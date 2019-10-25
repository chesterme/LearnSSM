package com.ch14.controller;

import com.ch14.pojo.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller("validateController")
@RequestMapping("/validate")
public class ValidateController {

    @RequestMapping("/toProduct")
    public ModelAndView pageToProduct(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product");
        return mv;
    }

    @RequestMapping("/annotation")
    public ModelAndView annotationValidate(@Valid @RequestBody Transaction trans, Errors errors){
        if(errors.hasErrors()){
            // 获取错误信息
            List<FieldError> errorList = errors.getFieldErrors();
            for(FieldError error : errorList){
                System.out.println("field: " + error.getField() + "\t" + "msg: " + error.getDefaultMessage());
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
