package com.fujitsu.ttf.yd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.entity.TypeOne;
import com.fujitsu.ttf.yd.service.TypeOneService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "工业胶管", tags = "工业胶管")
@Controller
@RequestMapping("typeOne")
public class TypeOneController {
	
	@Autowired
	private TypeOneService typeOneService;
	
	@PostMapping("selectTypeOneById")
	@ApiOperation(value = "查询工业胶管详细通过id", notes = "")
	@ResponseBody
	@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
    public TypeOne selectTypeOneById(Integer id) {
    	return typeOneService.selectTypeOneById(id);
    }
}
