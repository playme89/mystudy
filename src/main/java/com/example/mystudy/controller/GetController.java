package com.example.mystudy.controller;

import com.example.mystudy.model.SearchParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@Slf4j
public class GetController {

    @GetMapping("/getMethod")
    public String getRequest(){
            return "hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id,@RequestParam(name = "password") String pwd){
        System.out.println("id: " +id);
        System.out.println("password: "+pwd);
        return id+pwd;
    }

    @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }
}
