package com.park.pojo;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

/**
 * @ClassName: Encryption1
 * @Description: TODO
 * @Author: lenovo
 * @Date: 16:36 2021/7/27
 * @Version 1.0
 **/
public class Encryption1 {
    public final static String DES = "DES";

    public final static String DESEDE = "DESede";

    public final static String AES = "AES";

    public final static String BLOWFISH = "BlowFish";

    public final static String MD5 = "MD5";



    /**

     * md5加密

     *

     * @param data

     * @return

     */

    public static String getMD5(String data) {

        return null == data ? data : getMD5(string2byte(data));

    }



    private static String getMD5(byte str[]) {

        try {

            MessageDigest md = MessageDigest.getInstance(MD5);

            md.update(str);

            byte b[] = md.digest();

            return byte2hex(b);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }



    /**

     * 字符串加密

     *

     * @param data

     *            字符串数据

     * @param key

     *            密钥

     * @param name

     *            算法名称

     * @throws Exception

     */

    public static String encrypt(String data, String key, String name) {

        try {

            return byte2hex(encrypt(string2byte(data), string2byte(key), name));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }



    /**

     * 字符串解密

     *

     * @param data

     *            字符串加密数据

     * @param key

     *            密钥

     * @param name

     *            算法名称

     * @return

     * @throws Exception

     */

    public static String decrypt(String data, String key, String name) {

        try {

            return byte2string(decrypt(hex2byte(string2byte(data)),

                    string2byte(key), name));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }



    /**

     * 对数据源进行加密

     *

     * @param src

     *            数据源

     * @param key

     *            密钥

     * @param name

     *            算法的名称

     * @return 返回加密后的数据

     * @throws Exception

     */

    private static byte[] encrypt(byte[] src, byte[] key, String name)

            throws Exception {

        SecretKey securekey = new SecretKeySpec(key, name);

        Cipher cipher = Cipher.getInstance(name);

        cipher.init(Cipher.ENCRYPT_MODE, securekey);

        return cipher.doFinal(src);

    }



    /**

     * 对加密的数据源进行解密

     *

     * @param src

     *            数据源

     * @param key

     *            密钥

     * @param name

     *            算法的名称

     * @return 返回解密后的原始数据

     * @throws Exception

     */

    private static byte[] decrypt(byte[] src, byte[] key, String name)

            throws Exception {

        SecretKey securekey = new SecretKeySpec(key, name);

        Cipher cipher = Cipher.getInstance(name);

        cipher.init(Cipher.DECRYPT_MODE, securekey);

        return cipher.doFinal(src);

    }



    /**

     * 二进制转十六进制

     *

     * @param bytes

     * @return

     */

    private static String byte2hex(byte[] bytes) {

        String hex = "";

        if (bytes != null) {

            final int size = bytes.length;

            if (size > 0) {

                String tmp;

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < size; i++) {

                    tmp = (Integer.toHexString(bytes[i] & 0XFF));

                    if (tmp.length() == 1) {

                        sb.append("0" + tmp);

                    } else {

                        sb.append(tmp);

                    }

                }

                hex = sb.toString().toUpperCase();

            }

        }

        return hex;

    }



    /**

     * 十六进制转二进制

     *

     * @param bytes

     * @return

     */

    private static byte[] hex2byte(byte[] bytes) {

        if ((bytes.length % 2) != 0) {

            return null;

        }

        String item;

        byte[] result = new byte[bytes.length / 2];

        for (int i = 0; i < bytes.length; i += 2) {

            item = new String(bytes, i, 2);

            result[i / 2] = (byte) Integer.parseInt(item, 16);

        }

        return result;

    }



    /**

     * 把字符串转换成 Unicode Bytes.

     *

     * @param s

     *            String

     * @return byte[]

     */

    private static byte[] string2byte(String s) {

        byte[] bytes = null;

        if (s != null) {

            try {

                bytes = s.getBytes("utf-8");

            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();

            }

        }

        return bytes;

    }



    /**

     * 根据 Unicode Bytes 构造字符串.

     *

     * @param bytes

     *            byte[]

     * @return String

     */

    private static String byte2string(byte[] bytes) {

        String s = null;

        if (bytes != null) {

            try {

                s = new String(bytes, "utf-8");

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return s;

    }



    public static void main(String[] args) throws Exception {

/** DES算法 **/

        String src = "你好！";

        String key = "k>k2>&1&";

        String enc = "", dec = "";

        enc = encrypt(src, key, DES);

        System.out.println("11加密后的数据为:" + enc);

        dec = decrypt(enc, key, DES);

        System.out.println("11解密后的数据:" + dec);



        /* 若key的字节数大于8，则只取前8个字节 */

        KeySpec keySpec = new DESKeySpec(string2byte(key));

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);

        SecretKey secretKey = keyFactory.generateSecret(keySpec);

        /*

         * 在JAVA中DES默认使用DES/ECB/PKCS5Padding，下面的写法Cipher.getInstance(

         * "DES/ECB/PKCS5Padding")与 Cipher.getInstance("DES")等价

         */

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("12加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("12解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        /* CBC模式下，需要传入IV向量 ，IV向量的字节长度必须等于8 */

        AlgorithmParameterSpec paramSpec = new IvParameterSpec(string2byte(key));

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("13加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("13解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        /* NoPadding模式下，加密源数据的字节数必须是8的倍数 */

        src = "12345678";

        cipher = Cipher.getInstance("DES/ECB/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("14加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("14解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("DES/CBC/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("15加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("15解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



/** DESede算法 **/

        src = "你好！";

        key = "nohup command > f 2>&1 &";

        enc = encrypt(src, key, DESEDE);

        System.out.println("21加密后的数据为:" + enc);

        dec = decrypt(enc, key, DESEDE);

        System.out.println("21解密后的数据:" + dec);



        /* 若key的字节数大于24，则只取前24个字节 */

        keySpec = new DESedeKeySpec(string2byte(key));

        keyFactory = SecretKeyFactory.getInstance(DESEDE);

        secretKey = keyFactory.generateSecret(keySpec);

        /*

         * 在JAVA中DESede默认使用DESede/ECB/PKCS5Padding，下面的写法Cipher.getInstance(

         * "DESede/ECB/PKCS5Padding")与 Cipher.getInstance("DESede")等价

         */

        cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("22加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("22解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

        /* CBC模式下，需要传入IV向量 ，IV向量的字节长度必须等于8 */

        paramSpec = new IvParameterSpec(string2byte("k>k2>&1&"));

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("23加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("23解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        /* NoPadding模式下，加密源数据的字节数必须是8的倍数 */

        src = "12345678";

        cipher = Cipher.getInstance("DESede/ECB/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("24加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("24解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("DESede/CBC/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("25加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("25解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



/** AES算法 **/

        src = "你好！";

        key = "nohup cmd>f2>&1&";

        enc = encrypt(src, key, AES);

        System.out.println("31加密后的数据为:" + enc);

        dec = decrypt(enc, key, AES);

        System.out.println("31解密后的数据:" + dec);

        /* key的字节数必须等于16 */

        secretKey = new SecretKeySpec(string2byte(key), AES);

        /*

         * 在JAVA中AES默认使用AES/ECB/PKCS5Padding，下面的写法Cipher.getInstance(

         * "AES/ECB/PKCS5Padding")与 Cipher.getInstance("AES")等价

         */

        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("32加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("32解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        /* CBC模式下，需要传入IV向量 ，IV向量的字节长度必须等于16 */

        paramSpec = new IvParameterSpec(string2byte(key));

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("33加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("33解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        /* NoPadding模式下，加密源数据的字节数必须是16的倍数 */

        src = "1234567812345678";

        cipher = Cipher.getInstance("AES/ECB/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("34加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("34解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("AES/CBC/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("35加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("35解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        src = "你好！";

        key = "nohup cmd>f2>&1&";

        KeyGenerator kgen = KeyGenerator.getInstance(AES);

// ------------------------------

        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        random.setSeed(string2byte(key));

        kgen.init(128, random);

// ------------------------------

// 以上三行等价于kgen.init(128, new SecureRandom(string2byte(key)));

        secretKey = kgen.generateKey();

        secretKey = new SecretKeySpec(secretKey.getEncoded(), AES);// 这一行可以省略

        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("36加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("36解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("37加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("37解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        /* NoPadding模式下，加密源数据的字节数必须是16的倍数 */

        src = "1234567812345678";

        cipher = Cipher.getInstance("AES/ECB/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("38加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("38解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("AES/CBC/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("39加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("39解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



/** BlowFish算法 **/

        src = "你好！";

        key = "nohup cmd>f2>&1&";

        enc = encrypt(src, key, BLOWFISH);

        System.out.println("41加密后的数据为:" + enc);

        dec = decrypt(enc, key, BLOWFISH);

        System.out.println("41解密后的数据:" + dec);

        /* key的字节数必须大于等于1小于等于16 */

        secretKey = new SecretKeySpec(string2byte(key), BLOWFISH);

        /*

         * 在JAVA中BlowFish默认使用BlowFish/ECB/PKCS5Padding，下面的写法Cipher.getInstance(

         * "BlowFish/ECB/PKCS5Padding")与 Cipher.getInstance("BlowFish")等价

         */

        cipher = Cipher.getInstance("BlowFish/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("42加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("42解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("BlowFish/CBC/PKCS5Padding");

        /* CBC模式下，需要传入IV向量 ，IV向量的字节长度必须等于8 */

        paramSpec = new IvParameterSpec(string2byte("k>k2>&1&"));

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("43加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("43解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        /* NoPadding模式下，加密源数据的字节数必须是8的倍数 */

        src = "12345678";

        cipher = Cipher.getInstance("BlowFish/ECB/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        System.out.println("44加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        System.out.println("44解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));



        cipher = Cipher.getInstance("BlowFish/CBC/NoPadding");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);

        System.out.println("45加密后的数据为:"

                + (enc = byte2hex(cipher.doFinal(string2byte(src)))));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

        System.out.println("45解密后的数据:"

                + byte2string(cipher.doFinal(hex2byte(string2byte(enc)))));

    }
}
