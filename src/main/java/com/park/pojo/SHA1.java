package com.park.pojo;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @ClassName: Encryption
 * @Description: TODO
 * @Author: lenovo
 * @Date: 16:28 2021/7/27
 * @Version 1.0
 **/
public class SHA1 {
    public static final String KEY_SHA = "SHA";

    public static  String  getResult(String inputStr)
    {
        BigInteger sha =null;
        System.out.println("=======加密前的数据:"+inputStr);
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            System.out.println("SHA加密后:" + sha.toString(32));
        } catch (Exception e) {e.printStackTrace();}
        return sha.toString(32);
    }

    public static void main(String args[])
    {
        try {
            String inputStr = "你好";
            getResult(inputStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
