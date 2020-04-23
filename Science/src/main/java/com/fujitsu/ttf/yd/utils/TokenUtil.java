package com.fujitsu.ttf.yd.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class TokenUtil {
	
    //加密方式
    private static Algorithm algorithm = Algorithm.HMAC256("fnst.ttf.pwtURn2f");

    private static String issuer = "ttfPay";

    private static String LOGINIDKEY = "X-LOGINID";

    //有效日(30天)
    private static long expire = 1000L * 24L * 60L * 60L * 30L;

    public static String create(String openId) {
        String token = JWT.create()
                .withIssuer(issuer)
                .withClaim(LOGINIDKEY, openId)
                .withExpiresAt(new Date(System.currentTimeMillis() + expire))
                .sign(algorithm);
        return token;
    }

    public static String parse(String token) {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build();
        try {
            DecodedJWT jwt = verifier.verify(token);
            String loginId = jwt.getClaim(LOGINIDKEY).asString();
            
            return loginId;
        } catch (TokenExpiredException exp) {
        } catch (JWTVerificationException exp) {
        }
        return null;
    }

    
}
