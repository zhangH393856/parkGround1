package com.park.pojo;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @ClassName: MD5
 * @Description: TODO
 * @Author: lenovo
 * @Date: 16:42 2021/7/27
 * @Version 1.0
 **/
public class MD5 {
    String KEY_MD5 = "MD5";

    public String  getResult(String inputStr)
    {
        System.out.println("=======加密前的数据:"+inputStr);
        BigInteger bigInteger=null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {e.printStackTrace();}
        System.out.println("MD5加密后:" + bigInteger.toString(16));
        return bigInteger.toString(16);
    }

}
