package com.spring.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world!";
    }

    @RequestMapping("/hello1")
    public String hello1() {
        return "hello";
    }
}
