package com.spring.mvc.demo.controller;

import com.spring.mvc.demo.model.UserDO;
import com.spring.mvc.demo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String userList(ModelMap map) {
        map.put("users", loginService.getUserList());
        return "user/userList";
    }

    @RequestMapping(value = "/addInit", method = RequestMethod.GET)
    public String addInit() {
        return "user/userAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute UserDO user, Model model) {
        loginService.addUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/modifyInit", method = RequestMethod.GET)
    public String modifyInit(@RequestParam("userId") String userId, ModelMap model) {
        model.put("user", loginService.getUserById(userId));
        return "user/userModify";
    }

    @RequestMapping(value = "/modifyInit2/{userId}", method = RequestMethod.GET)
    public String modifyInit2(@PathVariable("userId") String userId, Map<String, Object> model) {
        model.put("user", loginService.getUserById(userId));
        return "user/userModify";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyUser(@ModelAttribute UserDO user, Model model) {
        loginService.modifyUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") String userId) {
        loginService.deleteUser(userId);
        return "redirect:/user/list";
    }
}
