package com.fujitsu.ttf.yd.utils;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.fujitsu.ttf.yd.entity.AccessToken;


	/**
	 * 菜单管理器类
	 * 
	 */
	public class MenuManager {

	/***
	 * 自定义菜单的创建步骤
		1、找到AppId和AppSecret。自定义菜单申请成功后，在“高级功能”-“开发模式”-“接口配置信息”的最后两项就是；
		2、根据AppId和AppSecret，以https get方式获取访问特殊接口所必须的凭证access_token；
		3、根据access_token，将json格式的菜单数据通过https post方式提交。

	 */		
		public final static String REAL_URL="http://www.contitechchinasolutions.com.cn/";
		//public final static String REAL_URL = "http://wxmobsa.yidatec.com/weixin/"; 
		
		public final static String appId="wx363c55c2dd6fc257";
		public final static String appSecret = "496547d6fbfa48e035323d073985ddd5";
		

		
		public static void main(String[] args) {
			// 第三方用户唯一凭证
			String appId = MenuManager.appId;
			// 第三方用户唯一凭证密钥
			String appSecret = MenuManager.appSecret;
			// 调用接口获取access_token
			AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		}

	}


