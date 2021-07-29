package com.park.controller;

import com.park.pojo.AdminTable;
import com.park.pojo.ParkTable;
import com.park.pojo.ParkuserTable;
import com.park.service.AdminService;
import com.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Author: lenovo
 * @Date: 15:08 2021/7/27
 * @Version 1.0
 **/
@Controller
public class LoginController {

@Autowired
    AdminService adminService;
@Autowired
    UserService userService;
    @RequestMapping("openlogin")
    public String login(){
        return "login";
    }
    @RequestMapping("openregister")
    public String openregister(){
        return "register";
    }
    @RequestMapping("logins")
    public String login(String name, String password, Model model, HttpSession session){
        List<AdminTable> adminTables=adminService.adminlogin(name,password);
        List<ParkuserTable> parkuserTables= userService.userlogin(name,password);
        if (adminTables.size()>0){
            session.setAttribute("name",name);
            List<ParkTable> selectpark = adminService.selectpark();
            model.addAttribute("parkList",selectpark);
        return "index";
        }else if (parkuserTables.size()>0){
            List<ParkTable> selectpark = adminService.selectpark();
            model.addAttribute("parkList",selectpark);
            session.setAttribute("name",name);
            return "services";
        }else {
            model.addAttribute("msg","用户名或密码错误，请重新输入！！");
            return  "login";
        }
    }

    @RequestMapping("index")
    public  String index(){
        return "contact";
    }
}
