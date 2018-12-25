package com.luoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoc
 * @date 2018/11/22 0022
 * @time 17:22
 */
@RestController()
@RequestMapping("/user")
public class UserController {

    @GetMapping("/greeting")
    public String a(){
         return "go";
    }
}
