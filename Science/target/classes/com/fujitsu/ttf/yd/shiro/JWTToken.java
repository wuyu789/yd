package com.fujitsu.ttf.yd.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 
 * @Description JWT Token
 * @author 鲜攀
 * @date: 2019年7月17日 上午10:40:36
 */
public class JWTToken implements AuthenticationToken {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
