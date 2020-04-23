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

import com.fujitsu.ttf.yd.entity.Cover;
import com.fujitsu.ttf.yd.service.CoverService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "封面", tags = "封面")
@Controller
@RequestMapping("cover")
public class CoverController {
	
   @Autowired
   private CoverService coverService;
	
   @GetMapping("getAllCover")
   @ApiOperation(value = "查询所有封面", notes = "")
   @ResponseBody
   @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
   public List<Cover> getAllCover(){
	   return coverService.getAllCover();
   }
}
