package com.fujitsu.ttf.yd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.entity.FirstLevelDirectory;
import com.fujitsu.ttf.yd.service.FirstLevelDirectoryService;
import com.fujitsu.ttf.yd.utils.Constants;
import com.fujitsu.ttf.yd.utils.TokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "一级目录", tags = "一级目录")
@Controller
@RequestMapping("firstLevel")
public class FirstLevelDirectoryController {
	 
	@Autowired
	private FirstLevelDirectoryService firstLevelDirectoryService;
	
	@ResponseBody
	@ApiOperation(value = "查询一级目录", notes = "")
	@GetMapping("getAllDirectory")
	@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
     public List<FirstLevelDirectory> getAllDirectory(HttpServletRequest request){
		String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
		String parse = TokenUtil.parse(token);
		System.out.println(parse);
    	return firstLevelDirectoryService.getAllDirectory();
     }
}
