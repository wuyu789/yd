/**
 * 
 */
package com.fujitsu.ttf.yd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.entity.SecondLevelDirectory;
import com.fujitsu.ttf.yd.service.SecondLevelDirectoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "二级目录", tags = "二级目录")
@Controller
@RequestMapping("secondlevel")
public class SecondLevelDirectoryController {
	 
	 @Autowired
	 private SecondLevelDirectoryService secondLevelDirectoryService;
	
	 @GetMapping("getAllSecondDirectoryByFirstId")
	 @ApiOperation(value = "根据一级目录的id查询二级目录", notes = "")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
     public List<SecondLevelDirectory> getAllSecondDirectoryByFirstId(Integer firstId){
    	 return secondLevelDirectoryService.getAllSecondDirectoryByFirstId(firstId);
	 }
}
