/**
 * 
 */
package com.fujitsu.ttf.yd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.entity.SendRecord;
import com.fujitsu.ttf.yd.service.SendRecordService;
import com.fujitsu.ttf.yd.utils.Constants;
import com.fujitsu.ttf.yd.utils.TokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "发送记录", tags = "发送记录")
@Controller
@RequestMapping("sendRecord")
public class SendRecordController {
	 
	 @Autowired
	 private SendRecordService sendRecordService;
	 
	 @GetMapping("selectSendRecordByUserId")
	 @ApiOperation(value = "查询发送记录", notes = "")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	 public List<SendRecord> selectSendRecordByUserId(HttpServletRequest request) {
		    String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
			String openid = TokenUtil.parse(token);
			return sendRecordService.selectSendRecordByUserId(openid);
	 }
}
