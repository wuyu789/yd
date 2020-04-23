package com.fujitsu.ttf.yd.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.service.ProductFeaturesService;
import com.fujitsu.ttf.yd.utils.Constants;
import com.fujitsu.ttf.yd.utils.TokenUtil;
import com.fujitsu.ttf.yd.vo.management.ProductVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
*@author shik.jy
*@date 2019年10月21日
*@Description
*/

@Api(value = "产品特性下拉框", tags = "产品特性下拉框")
@Controller
@RequestMapping("product")
public class ProductFeaturesController {
	
	 @Autowired
     private ProductFeaturesService productFeaturesService;
     
     @GetMapping("getAllInfos")
     @ApiOperation(value = "查询所有产品特性", notes = "")
     @ResponseBody
     @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
     public Map<String, Object> getAllProducts(int secondId){
    	 return productFeaturesService.getAllProduct(secondId);
     }
     
     @PostMapping("getPageThrid")
     @ApiOperation(value = "根据下拉框条件筛选数据并且带分页", notes = "")
     @ResponseBody
     public Map<String,Object> getPageThrid(ProductVo productVo,HttpServletRequest request){
    	 String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
		 String openid = TokenUtil.parse(token);
    	 return productFeaturesService.getAllProduct(productVo.getKeys(),productVo.getValues(),productVo.getPage(),productVo.getSize(),productVo.getSecondId(),openid);
     }

}
