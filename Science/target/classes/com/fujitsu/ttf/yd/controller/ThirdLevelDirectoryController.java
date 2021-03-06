/**
 * 
 */
package com.fujitsu.ttf.yd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.entity.Collect;
import com.fujitsu.ttf.yd.entity.ThirdLevelDirectory;
import com.fujitsu.ttf.yd.service.CollectService;
import com.fujitsu.ttf.yd.service.ThirdLevelDirectoryService;
import com.fujitsu.ttf.yd.utils.Constants;
import com.fujitsu.ttf.yd.utils.TokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author wuyu
 *
 */
@Api(value = "三级目录", tags = "三级目录")
@Controller
@RequestMapping("thirdLevel")
public class ThirdLevelDirectoryController {
	 
	 @Autowired
	 private ThirdLevelDirectoryService thirdLevelDirectoryService;
	 
	 @Autowired
	 private CollectService collectService;
	
	 @ApiOperation(value = "根据二级目录的id查询三级目录", notes = "")
	 @GetMapping("getAllThirdLevelDirectoryBySecondId")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
     public Object getAllThirdLevelDirectoryBySecondId(Integer secondId,Integer page,Integer pageSize,HttpServletRequest request){
		 String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
		 String openid = TokenUtil.parse(token);
		 //String openid="1";
    	 return thirdLevelDirectoryService.getAllThirdLevelDirectoryBySecondId(secondId,page,pageSize,openid);
     }
	 
	 @ApiOperation(value = "根据三级目录的名称查询三级目录(模糊查询)", notes = "")
	 @GetMapping("selectThirdLevelDirectoryByThirdName")
	 @ResponseBody
	 //@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	 public Object selectThirdLevelDirectoryByThirdName(String thirdName,Integer page,Integer pageSize,HttpServletRequest request){
//		 String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
//		 String openid = TokenUtil.parse(token);
		 return thirdLevelDirectoryService.selectThirdLevelDirectoryByThirdName(thirdName,page,pageSize,"1");
	 }
	 
	 @ApiOperation(value = "根据三级目录的名称获取单条记录", notes = "")
	 @GetMapping("selectDataByThirdName")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	 public ThirdLevelDirectory selectDataByThirdName(String thirdName) {
		 return thirdLevelDirectoryService.selectDataByThirdName(thirdName);
	 }
	 
	 @ApiOperation(value = "我的收藏", notes = "")
	 @GetMapping("selectCollectDirectory")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	 public Object selectCollectDirectory(Integer page,Integer pageSize,HttpServletRequest request){
		 String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
		 String openid = TokenUtil.parse(token);
		 //String openid="1";
		 return thirdLevelDirectoryService.selectCollectDirectory(openid,page,pageSize);
	 }
	 
	 @ApiOperation(value = "添加(取消)收藏", notes = "")
	 @GetMapping("insertCollect")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	 public String insertCollect(Integer thirdId,HttpServletRequest request) {
		 String token = (String)request.getHeader(Constants.HEADER_AUTHORIZATION);
		 String openid = TokenUtil.parse(token);
		 //String openid="1";
		 Collect collect = collectService.selectCollect(openid, thirdId);
		 ThirdLevelDirectory directory = thirdLevelDirectoryService.selectThirdLevelDirectoryById(thirdId);
		 // 收藏量
		 Integer collectCount = directory.getCollectCount();
		 if(collect==null) {
			 thirdLevelDirectoryService.insertCollect(openid, thirdId);
			 collectCount++;
			 thirdLevelDirectoryService.updateData(thirdId, collectCount);
			 return "添加成功";
		 }else {
			 thirdLevelDirectoryService.deleteCollect(openid, thirdId);
			 if(collectCount==0 || collectCount==null) {
				 collectCount=0;
			 }else {
				 collectCount--;
			 }
			 thirdLevelDirectoryService.updateData(thirdId, collectCount);
			 return "删除成功";
		 }
	 }
	 
	 @ApiOperation(value = "点击量", notes = "")
	 @GetMapping("addClickNum")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	 public void addClickNum(String thirdName) {
		 thirdLevelDirectoryService.addClickNum(thirdName);
	 }
	 
	 @ApiOperation(value = "下载量", notes = "")
	 @GetMapping("addDownloadNum")
	 @ResponseBody
	 @ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header")
	 public void addDownloadNum(String thirdName) {
		 thirdLevelDirectoryService.addDownloadNum(thirdName);
	 }
	 
	 @ApiOperation(value = "查询点击量和下载量", notes = "")
	 @GetMapping("selectDownloadNumAndClickNum")
	 @ResponseBody
	 public Object selectDownloadNumAndClickNum(Integer firstId,Integer secondId,Integer page,Integer pageSize) {
		 return thirdLevelDirectoryService.selectDownloadNumAndClickNum(firstId,secondId,page,pageSize);
	 }
}
