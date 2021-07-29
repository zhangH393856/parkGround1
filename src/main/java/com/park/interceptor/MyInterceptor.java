package com.park.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MyInterceptor
 * @Description: TODO
 * @Author: lenovo
 * @Date: 15:32 2021/7/26
 * @Version 1.0
 **/
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String name= (String) request.getSession().getAttribute("name");
        if (name==null||"".equals(name)){
            request.setAttribute("msg","请先登录！！");
            request.getRequestDispatcher("openlogin").forward(request,response);
            return false;
        }
      return  true;
    }
}
