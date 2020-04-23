/**
 * 
 */
package com.fujitsu.ttf.yd.service;

import com.fujitsu.ttf.yd.entity.ThirdLevelDirectory;

/**
 * @author wuyu
 *
 */
public interface ThirdLevelDirectoryService {
	  Object getAllThirdLevelDirectoryBySecondId(Integer secondId,Integer page,Integer pageSize,String openid);
	
	  Object selectThirdLevelDirectoryByThirdName(String thirdName,Integer page,Integer pageSize,String openid);
	  
	  ThirdLevelDirectory selectDataByThirdName(String thirdName);
	  
	  Object selectCollectDirectory(String openid,Integer page,Integer pageSize);
	  
	  public void insertCollect(String openid,Integer thirdId);
	  
	  public void deleteCollect(String openid,Integer thirdId);
	  
	  public ThirdLevelDirectory selectThirdLevelDirectoryById(Integer thirdId);
	  
	  public void updateData(Integer thirdId,Integer collectCount);
	  
	  // 点击量
	  public void addClickNum(String thirdName);
	  // 下载量
	  public void addDownloadNum(String thirdName);
	  // 查询点击量和下载量
	  public Object selectDownloadNumAndClickNum(Integer firstId,Integer secondId,Integer page,Integer pageSize);
}
