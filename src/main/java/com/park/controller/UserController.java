package com.park.controller;

import com.park.pojo.LineTable;
import com.park.pojo.ParkuserTable;
import com.park.pojo.UserbindTable;
import com.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: lenovo
 * @Date: 16:11 2021/7/27
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;
    //注册
@RequestMapping("register")
    public String register(ParkuserTable parkuserTable){
    userService.insertuser(parkuserTable);
    return "success";
}
//个人排队
    @RequestMapping("oneLineup")
    public String oneLineup(String parkName, String userName, Model model){
        List<LineTable> lineTables = userService.selectLine(userName, parkName);
        if (lineTables.size()>0){
            model.addAttribute("msg","您已经在排队中,请勿重复排队");
            return "success";
        }else{
            userService.insertpeople(userName,parkName);
            model.addAttribute("msg","排队成功,请注意查看手机，别错过入园时间");
            return "success";
        }

    }
    //好友组队
    @RequestMapping("insertfriend")
    public  String openinsertfriend(String userName, Model model, HttpSession session,String parkName){
        List<UserbindTable> userbindTables = userService.lineUp(userName);
        model.addAttribute("lineup",userbindTables);
        session.setAttribute("parkName",parkName);
        return "insertfriend";
    }
//添加好友
    @RequestMapping("insertfriends")
    public String insertfriend(UserbindTable userbindTable, Model model){
    userService.insertUserbing(userbindTable);
        List<UserbindTable> userbindTables = userService.lineUp(userbindTable.getUserName());
        model.addAttribute("lineup",userbindTables);
        return "insertfriend";
    }
    //删除好友
    @RequestMapping("deletefriends")
    public String deletefriend(Integer id,Model model,String name){
        userService.deleteUserbind(id);
        List<UserbindTable> userbindTables = userService.lineUp(name);
        model.addAttribute("lineup",userbindTables);
        return "insertfriend";
    }
    //添加收藏
    //取消收藏
    @RequestMapping("openMap")
    public String openMap(){
    return "autoSetZoom";
    }
}
