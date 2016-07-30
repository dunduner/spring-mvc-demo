package com.spring.mvc.demo.model;

import lombok.Data;

/**
 * Created by zhangls on 2016/7/30 0030.
 */
@Data
public class UserDO {
    private String userId;

    private String userName;
    private String password;
    private String email;
    private String address;
    private String sex;
    private String birthday;
    private String phone;

}
