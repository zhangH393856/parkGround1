package com.park.service;

import com.park.mapper.AdminTableMapper;
import com.park.mapper.ParkTableMapper;
import com.park.pojo.AdminTable;
import com.park.pojo.AdminTableExample;
import com.park.pojo.MD5;
import com.park.pojo.ParkTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AdminService
 * @Description: TODO
 * @Author: lenovo
 * @Date: 16:12 2021/7/27
 * @Version 1.0
 **/
@Service
public class AdminService {
    @Autowired
    AdminTableMapper adminTableMapper;
    @Autowired
    ParkTableMapper parkTableMapper;
    //查询(登陆验证)
    public List<AdminTable> adminlogin(String name,String password){
        MD5 md5=new MD5();
        AdminTableExample adminTableExample=new AdminTableExample();
        adminTableExample.createCriteria().andNameEqualTo(name).andPasswordEqualTo(md5.getResult(password));
        return adminTableMapper.selectByExample(adminTableExample);
    }
    //新增游乐场游乐项目
    public int insertparkground(ParkTable parkTable){
     return    parkTableMapper.insertSelective(parkTable);
    }
    //查询所有娱乐场项目、
    public List<ParkTable> selectpark(){
        return parkTableMapper.selectByExample(null);
    }
}
