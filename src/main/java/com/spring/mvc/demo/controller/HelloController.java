package com.spring.mvc.demo.controller;

import com.spring.mvc.demo.model.Score;
import com.spring.mvc.demo.model.SystemRole;
import com.spring.mvc.demo.model.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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


    /**
     * 测试Boolean转换String
     *
     * @param bool
     * @return
     */
    //http://localhost:8888/spring-mvc-demo/mvc/converter?bool=no
    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    @ResponseBody
    public String converter(Boolean bool) {
        return bool.toString();
    }

    //http://localhost:8888/spring-mvc-demo/mvc/formatter/date?date=2016-07-01
    @RequestMapping(value = "/formatter/date", method = RequestMethod.GET)
    @ResponseBody
    public String formatterDate(Date date) {
        return date.toString();
    }

    //http://localhost:8888/spring-mvc-demo/mvc/converter/date?date=2016-07-01
    @RequestMapping(value = "/converter/date", method = RequestMethod.GET)
    @ResponseBody
    public String converterDate(Date date) {
        return date.toString();
    }

    /**
     * json 数据的绑定 Chrome DHC工具
     * {"item":"语文","scoreNum":"100"}
     * @param score
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody
    public String jsonBinding(@RequestBody Score score) {
        return score.toString();
    }
}
