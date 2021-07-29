package com.park.service;

import com.park.mapper.LineTableMapper;
import com.park.mapper.ParkTableMapper;
import com.park.mapper.ParkuserTableMapper;
import com.park.mapper.UserbindTableMapper;
import com.park.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: lenovo
 * @Date: 16:12 2021/7/27
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    ParkuserTableMapper parkuserTableMapper;
    @Autowired
    ParkTableMapper parkTableMapper;
    @Autowired
    UserbindTableMapper userbindTableMapper;
    @Autowired
    LineTableMapper lineTableMapper;

    //登陆验证
    public List<ParkuserTable> userlogin(String name, String password) {
        MD5 md5 = new MD5();
        ParkuserTableExample parkuserTableExample = new ParkuserTableExample();
        parkuserTableExample.createCriteria().andUserNameEqualTo(name).andUserPasswordEqualTo(md5.getResult(password));
        return parkuserTableMapper.selectByExample(parkuserTableExample);
    }

    //添加用户
    public int insertuser(ParkuserTable parkuserTable) {
        MD5 md5 = new MD5();
        parkuserTable.setUserPassword(md5.getResult(parkuserTable.getUserPassword()));
        parkuserTable.setUserPhone(md5.getResult(parkuserTable.getUserPhone()));
        parkuserTable.setUserId(md5.getResult(parkuserTable.getUserId()));
        return parkuserTableMapper.insertSelective(parkuserTable);
    }

    //收藏(先根据id查到该数据)
    public ParkTable selectparkId(Integer id) {
        return parkTableMapper.selectByPrimaryKey(id);
    }

    //修改收藏状态
    public int updateparkcollection(ParkTable parkTable) {
        //收藏
        if (parkTable.getParkCollection() == 0) {
            parkTable.setParkCollection(1);
            parkTableMapper.updateByPrimaryKey(parkTable);
            return 1;
        }
        //取消收藏
        else if (parkTable.getParkCollection() == 1) {
            parkTable.setParkCollection(0);
            parkTableMapper.updateByPrimaryKey(parkTable);
            return 0;
        } else {
            return -1;
        }
    }

    //添加朋友
    public int insertUserbing(UserbindTable userbindTable, String name) {
        userbindTable.setUserName(name);
        return userbindTableMapper.insertSelective(userbindTable);
    }

    //用户绑定的朋友信息
    public List<UserbindTable> lineUp(String name) {
        //根据姓名查询绑定的朋友信息
        UserbindTableExample userbindTableExample = new UserbindTableExample();
        userbindTableExample.createCriteria().andUserNameEqualTo(name);
        return userbindTableMapper.selectByExample(userbindTableExample);
    }

    //与朋友一起排队
    public int LineUp(List<String> frindName, String parkName, String userName) {
        int peopleNumber = 1;
        LineTable lineTable1 = new LineTable();
        lineTable1.setLineUsername(userName);
        lineTable1.setLineParkname(parkName);
        lineTable1.setLineState("排队中");
        lineTableMapper.insertSelective(lineTable1);
        //遍历添加的排队朋友
        for (int i = 0; i < frindName.size(); i++) {
            peopleNumber++;
            UserbindTableExample userbindTableExample = new UserbindTableExample();
            //根据绑定用户的姓名查找
            userbindTableExample.createCriteria().andUserNameEqualTo(frindName.get(i));
            List<UserbindTable> userbindTables = userbindTableMapper.selectByExample(userbindTableExample);
            UserbindTable userbindTable = userbindTables.get(0);
            userbindTable.setBindState("1");
            //插入排队数据
            LineTable lineTable = new LineTable();
            lineTable.setLineUsername(frindName.get(i));
            lineTable.setLineParkname(parkName);
            lineTable.setLineState("排队中");
            lineTableMapper.insertSelective(lineTable);
        }
        ParkTableExample parkTableExample = new ParkTableExample();
        parkTableExample.createCriteria().andParkNameEqualTo(parkName);
        List<ParkTable> parkTables = parkTableMapper.selectByExample(parkTableExample);
        ParkTable parkTable = parkTables.get(0);
        List<LineTable> lineTables = lineTableMapper.selectByExample(null);
        for (int i = 0; i < lineTables.size(); i++) {
            peopleNumber++;
            if (userName.equals(lineTables.get(i).getLineUsername())) {
                break;
            }
        }
        //当前排队人数
        parkTable.setParkNewpeople(peopleNumber);
        parkTable.setParkWaittime(parkTable.getParkNewpeople());
        return parkTableMapper.updateByPrimaryKey(parkTable);
    }
    //个人排队
    public int insertpeople(String userName,String parkName){
        LineTable lineTable1 = new LineTable();
        lineTable1.setLineUsername(userName);
        lineTable1.setLineParkname(parkName);
        lineTable1.setLineState("排队中");
       return lineTableMapper.insertSelective(lineTable1);
    }
    //排队判断
    public List<LineTable> selectLine(String userName,String parkName){
        LineTableExample lineTableExample=new LineTableExample();
        lineTableExample.createCriteria().andLineParknameEqualTo(parkName).andLineUsernameEqualTo(userName);
        return lineTableMapper.selectByExample(lineTableExample);
    }
    //取消排队
    public int updateuser(String userName, String parkName) {

        return 1;
    }


}
