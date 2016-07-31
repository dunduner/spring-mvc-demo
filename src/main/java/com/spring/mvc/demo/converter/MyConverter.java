package com.spring.mvc.demo.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by zhangls on 2016/7/31 0031.
 */
public class MyConverter implements Converter<String, Date>{

    @Override
    public Date convert(String s) {
        return null;
    }
}
