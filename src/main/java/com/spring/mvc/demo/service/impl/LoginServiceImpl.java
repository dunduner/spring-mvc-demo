package com.spring.mvc.demo.service.impl;

import com.google.common.collect.Lists;
import com.spring.mvc.demo.model.UserDO;
import com.spring.mvc.demo.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static List<UserDO> ls = Lists.newArrayList();

    static {
        ls  = initUserList();
    }

    private static List<UserDO> initUserList(){
        UserDO user = new UserDO();
        user.setUserId("001");
        user.setUserName("张三");
        user.setPassword("123456");
        user.setAddress("河南郑州");
        user.setSex("男");
        user.setBirthday("1990-11-29");
        user.setEmail("zhangsan@gmail.com");
        user.setPhone("13612345678");

        ls.add(user);

        UserDO user1 = new UserDO();
        user1.setUserId("002");
        user1.setUserName("李四");
        user1.setPassword("654321");
        user1.setAddress("河南商丘");
        user1.setSex("女");
        user1.setBirthday("1980-11-29");
        user1.setEmail("lisi@gmail.com");
        user1.setPhone("13987654321");

        ls.add(user1);

        return ls;
    }

    @Override
    public List<UserDO> getUserList() {
        return ls;
    }

    @Override
    public UserDO getUserById(String userId) {

        for(UserDO u : ls){
            if(userId.equals(u.getUserId())){
                return u;
            }
        }

        return null;
    }

    @Override
    public Boolean valLogin(UserDO user) {
        String username = user.getUserName();
        String password = user.getPassword();
        for(UserDO u : ls){
            if(username.equals(u.getUserName()) && password.equals(u.getPassword())){
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean modifyUser(UserDO user) {
        for (UserDO u : ls){
            if(user.getUserId().equals(u.getUserId())){
                ls.remove(u);
                ls.add(user);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean addUser(UserDO user) {

        ls.add(user);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteUser(String userId) {
        for (UserDO u : ls){
            if(userId.equals(u.getUserId())){
                ls.remove(u);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
