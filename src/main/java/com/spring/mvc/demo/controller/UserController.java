package com.spring.mvc.demo.controller;

import com.spring.mvc.demo.model.UserDO;
import com.spring.mvc.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

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
    public String addUser(@ModelAttribute UserDO user) {
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
    public String modifyUser(@ModelAttribute UserDO user) {
        loginService.modifyUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") String userId) {
        loginService.deleteUser(userId);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete2", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {

        String userId = String.valueOf(request.getParameter("userId"));
        loginService.deleteUser(userId);
        return "redirect:/user/list";
    }

    //http://localhost:8888/spring-mvc-demo/user/user.json/001
    @RequestMapping(value = "/user.json/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public UserDO viewUser(@PathVariable("userId") String userId) {
        log.debug("function viewUser userId={}",userId);
        UserDO userDO = loginService.getUserById(userId);

        return userDO;
    }

    //http://localhost:8888/spring-mvc-demo/user/users.json
    @RequestMapping(value = "/users.json", method = RequestMethod.POST)
    public ResponseEntity<List<UserDO>> viewUser() {
        return new ResponseEntity<List<UserDO>>(loginService.getUserList(), HttpStatus.OK);
    }
}
