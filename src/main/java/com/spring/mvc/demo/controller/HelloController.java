package com.spring.mvc.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Slf4j
@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        log.debug("执行了 HelloController 中的 hello 方法");
        return "hello world!";
    }

    @RequestMapping("/hello1")
    public String hello1() {
        log.debug("执行了 HelloController 中的 hello1 方法");
        return "hello";
    }
}
