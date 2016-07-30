package com.spring.mvc.demo.controller;

import com.spring.mvc.demo.model.UserDO;
import com.spring.mvc.demo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/init")
    public String loginInit(){
        log.debug("登录页面初始化！");
        return "login/login";
    }

    @RequestMapping(value = "/valLogin",method = RequestMethod.POST)
    public String valLogin(UserDO user){
        log.debug("验证登陆，username:{},password:{}",user.getUserName(),user.getPassword());

        if(loginService.valLogin(user)){
            return "redirect:/user/list";
        }

        return "redirect:/login/init";
    }

}
