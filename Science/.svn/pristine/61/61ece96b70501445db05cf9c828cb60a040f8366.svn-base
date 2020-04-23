package com.fujitsu.ttf.yd.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 
 * @Description MD5工具类
 * @author 鲜攀
 * @date: 2019年6月27日 下午11:36:49
 */
public class Md5Util {

	/**
     * 生成随机盐,长度32位
     * @return
     */
    public static String generateSalt(){
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(16).toHex();
        return hex;
    }
    /**
     * Md5 加密密码
     * @param password 密码
     * @param staffNumber 员工工号
     * @return 加密后的密码
     */
    public static String encryptPassword(String password,String staffNumber) {
    	Md5Hash hash = new Md5Hash(password, staffNumber, 1024);
    	return hash.toHex();
    }

}