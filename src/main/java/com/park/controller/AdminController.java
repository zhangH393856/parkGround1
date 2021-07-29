package com.park.controller;

import com.park.pojo.DateUtil;
import com.park.pojo.ParkTable;
import com.park.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: AdminController
 * @Description: TODO
 * @Author: lenovo
 * @Date: 16:11 2021/7/27
 * @Version 1.0
 **/
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("openparkground")
    public String openparkground(){
        return "file";
    }
//添加游乐场项目
    @RequestMapping("insert")
    public String insert(ParkTable parkTable, HttpSession session) throws IOException {
        String  filename = (String) session.getAttribute("file");
        parkTable.setParkFile(filename);
        adminService.insertparkground(parkTable);
        session.removeAttribute("file");
        return "success";
    }
    //上传图片
    @RequestMapping("insertfile")
    public String insertfile(MultipartFile parkFile, HttpSession session) throws IOException {
        String filepath = "D:\\ParkGround\\src\\main\\resources\\static\\dist\\img";
        String FileName = parkFile.getOriginalFilename();
        String newFileName = UUID.randomUUID() + FileName;
        File targetFile = new File(filepath, newFileName);
        parkFile.transferTo(targetFile);
        session.setAttribute("file",newFileName);
        return "adminparkground";
    }
    //显示游乐项目
@RequestMapping("parklist")
public String selectpark(Model model){
    List<ParkTable> selectpark = adminService.selectpark();
    model.addAttribute("parkList",selectpark);
    return "services";
}
@Scheduled(fixedRate = 20000)
    public void inserts(){
    System.out.println("定时任务时间:"+ DateUtil.getDate(new Date()));

}


}
