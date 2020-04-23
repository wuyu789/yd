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

import com.fujitsu.ttf.yd.entity.Carousel;
import com.fujitsu.ttf.yd.service.CarouselService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "轮播图", tags = "轮播图")
@Controller
@RequestMapping("carouselController")
public class CarouselController {
	
	@Autowired
	private CarouselService carouselService;
	
	@GetMapping("getAllCarouselVo")
	@ApiOperation(value = "查询所有轮播图", notes = "")
	@ResponseBody
	@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	public List<Carousel> getAllCarouselVo(){
		return carouselService.getAllCarouselVo();
	}
}
