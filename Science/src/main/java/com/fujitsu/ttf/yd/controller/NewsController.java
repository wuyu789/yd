package com.fujitsu.ttf.yd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.entity.News;
import com.fujitsu.ttf.yd.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "首页新闻", tags = "新闻")
@Controller
@RequestMapping("newSController")
public class NewsController {
	
     @Autowired
     private NewsService newsService;
     
     @GetMapping("getAllNews")
     @ApiOperation(value = "查询所有新闻", notes = "")
     @ResponseBody
     @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
     public List<News> getAllNews(){
    	 return newsService.getAllNews();
     }
}
