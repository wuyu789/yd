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

import com.fujitsu.ttf.yd.entity.HistorySearch;
import com.fujitsu.ttf.yd.service.HistorySearchService;
import com.fujitsu.ttf.yd.utils.Constants;
import com.fujitsu.ttf.yd.utils.TokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @Description
 * @author 吴雨
 * @date: 2019年12月14日 下午6:55:55
 */
@Api(value = "历史搜索记录", tags = "历史搜索记录")
@Controller
@RequestMapping("historySearchController")
public class HistorySearchController {
	
	@Autowired
	private HistorySearchService historySearchService;
	
	@GetMapping("getHistorySearch")
	@ApiOperation(value = "查询所有历史搜索记录", notes = "")
	@ResponseBody
	@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	public List<HistorySearch> getHistorySearch(HttpServletRequest request){
		String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
		String openid = TokenUtil.parse(token);
		return historySearchService.getHistorySearch(openid);
	}
}
