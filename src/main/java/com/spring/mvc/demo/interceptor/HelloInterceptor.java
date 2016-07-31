package com.spring.mvc.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangls on 2016/7/31 0031.
 */
@Slf4j
public class HelloInterceptor implements HandlerInterceptor {

    /**
     * 拦截器预处理方法
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return true:继续执行拦截对象 false:终止调用拦截对象
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.debug("执行了 HelloInterceptor 中的 preHandle 方法");

        return true;
    }

    /**
     * 拦截对象执行方法
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.debug("执行了 HelloInterceptor 中的 postHandle 方法");
    }

    /**
     * 拦截完成后执行方法
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.debug("执行了 HelloInterceptor 中的 afterCompletion 方法");
    }
}
