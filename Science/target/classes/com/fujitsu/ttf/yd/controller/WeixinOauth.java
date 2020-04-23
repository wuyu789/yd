package com.fujitsu.ttf.yd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fujitsu.ttf.yd.entity.Users;
import com.fujitsu.ttf.yd.mapper.UsersMapper;
import com.fujitsu.ttf.yd.utils.MenuManager;
import com.fujitsu.ttf.yd.utils.TokenUtil;
import com.fujitsu.ttf.yd.utils.WeixinUtil;

import net.sf.json.JSONObject;

/*
 * @author david
 * 微信公众号oauth2.0授权
 * 
 */
@Controller
@RequestMapping("weixin")
public class WeixinOauth {
	
	@Autowired
	private UsersMapper usersMapper;
	/**
	 * 第一步：用户同意授权，获取code
	 */
	@GetMapping("industry") // weixin/industry
	public void oauth(HttpServletResponse response) throws IOException {
		String path = MenuManager.REAL_URL + "weixin/invoke";
		try {
			path = URLEncoder.encode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + MenuManager.appId // !appid
				+ "&redirect_uri=" + path + "&response_type=code" + "&scope=snsapi_userinfo" + "&state=java" + "&connect_redirect=1"
				+ "#wechat_redirect";
		response.sendRedirect(url);
	}
    
	// 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
	@GetMapping("invoke") // 域名+weixin/invoke
	public ModelAndView oauthInvoke(HttpServletRequest request) {
		// 2.获得code
		String code = request.getParameter("code");
		//String state = request.getParameter("state");

		// 3通过code换取网页授权access_token
		// 认证服务器
		String url = " https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=" + MenuManager.appId + "&secret="
				+ MenuManager.appSecret + "&code=" + code + "&grant_type=authorization_code";
		// 认证服务器 带着code发送请求 得到access_token
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "GET", null);
		//System.out.println(jsonObject.toString());
		String accessToken = jsonObject.getString("access_token");
		String openid = jsonObject.getString("openid");
		// 4带着openid和access_token 获得资源信息
		String urlUserInfo = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=" + accessToken + "&openid="
				+ openid + "&lang=zh_CN";
		JSONObject jsonObj = WeixinUtil.httpRequest(urlUserInfo, "GET", null);
		System.out.println(jsonObj);
		Users user=new Users();
		user.setOpenid(jsonObj.getString("openid"));
		user.setNickname(jsonObj.getString("nickname"));
		user.setSex(jsonObj.getString("sex"));
		user.setLanguage(jsonObj.getString("language"));
		user.setCity(jsonObj.getString("city"));
		user.setProvince(jsonObj.getString("province"));
		user.setCountry(jsonObj.getString("country"));
		user.setHeadimgurl(jsonObj.getString("headimgurl"));
		user.setUnionid(jsonObj.getString("unionid"));
		Users users = usersMapper.findUsersByOpenid(user.getOpenid());
		System.out.println(users);
		if(users!=null) {
		   usersMapper.UpdateUsers(user);
		}else {
		   usersMapper.insertUsers(user);
		}
//		ModelAndView model = new ModelAndView();
//		model.addObject("jsonObj", jsonObj);
		// model.setViewName("index");
        //request.setAttribute("param", jsonObj);
		//return "index";
        String token = TokenUtil.create(openid);
	    String urlImg="http://www.contitechchinasolutions.com.cn/web/frontend?token="+token;
		return new ModelAndView(new RedirectView(urlImg));
	}

}
