package com.spring.mvc.demo.service;

import com.spring.mvc.demo.model.UserDO;

import java.util.List;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
public interface LoginService {

    public List<UserDO> getUserList();

    public Boolean valLogin(UserDO user);

    public Boolean modifyUser(UserDO user);

    public Boolean addUser(UserDO user);

    public Boolean deleteUser(String userId);

    public UserDO getUserById(String userId);
}
