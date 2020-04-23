package com.fujitsu.ttf.yd.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fujitsu.ttf.yd.enums.ResultEnum;
import com.fujitsu.ttf.yd.exception.ErrorException;

import java.util.Date;
/**
 * 
 * @Description JWT 工具类
 * @author 鲜攀
 * @date: 2019年6月27日 下午11:43:17
 */
public class JWTUtil {

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 24*60*60*1000;

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param staffNumber 员工工号
     * @param secret 员工的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String staffNumber, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(Constants.STAFF_NUMBER, staffNumber)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getStaffNumber(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("X-LOGINID").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     * @param staffNumber 员工工号
     * @param secret 员工的密码
     * @return 加密的token
     */
    public static String sign(String staffNumber, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带staffNumber信息
            return JWT.create()
                    .withClaim(Constants.STAFF_NUMBER, staffNumber)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            throw new ErrorException(ResultEnum.TOKEN_CREATE_FAIL);
        }
    }
    
}
