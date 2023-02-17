package com.example.mystudy.controller;

import com.example.mystudy.model.SearchParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api")
public class RestController {


    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }
    @PutMapping("/putMethod")
    public String putMapping(){
        return "";
    }
    @PatchMapping("/patchMethod")
    public String patchMapping(){
        return "";
    }
}
