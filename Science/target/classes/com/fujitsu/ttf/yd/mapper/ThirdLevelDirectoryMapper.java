package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fujitsu.ttf.yd.entity.ThirdLevelDirectory;

/**
 * @author wuyu
 *
 */
@Mapper
public interface ThirdLevelDirectoryMapper {
	
	 public List<ThirdLevelDirectory> getAllThirdLevelDirectoryBySecondId(@Param("secondId")Integer secondId);

	 public List<ThirdLevelDirectory> getAllThirdLevelData(List<Integer> ids);
	 
	 public List<ThirdLevelDirectory> selectThirdLevelDirectoryByThirdName(@Param("thirdName")String thirdName);
	 
	 public ThirdLevelDirectory selectDataByThirdName(@Param("thirdName")String thirdName);
	 
	 public void insertCollect(@Param("openid")String openid,@Param("thirdId")Integer thirdId);
	 
	 public void deleteCollect(@Param("openid")String openid,@Param("thirdId")Integer thirdId);
	 
	 public void selectCollect(@Param("openid")String openid,@Param("thirdId")Integer thirdId);
	 
	 public void updateThirdLevelDirectory(@Param("userId")String userId);
	 
	 public List<ThirdLevelDirectory> selectCollectDirectory(@Param("openid")String openid);
	 
	 public ThirdLevelDirectory selectThirdLevelDirectoryById(@Param("thirdId")Integer thirdId);
	 
	 public void updateData(@Param("thirdId")Integer thirdId,@Param("collectCount")Integer collectCount);
	 
	 public List<ThirdLevelDirectory> getDataType1(@Param("productName") String productName);
	 
	 public List<ThirdLevelDirectory> getDataType2(@Param("productName") String productName);
     //点击量
	 public void addClickNum(@Param("thirdName")String thirdName,@Param("clickNum")Integer clickNum);
	 //下载量
	 public void addDownloadNum(@Param("thirdName")String thirdName,@Param("downloadNum")Integer downloadNum);
	 // 查询点击量和下载量
	 public List<ThirdLevelDirectory> selectDownloadNumAndClickNum(@Param("secondArray") String secondArray);
	 
	 public ThirdLevelDirectory selectThirdLevelDirectoryAndTypeOne(@Param("id") Integer id);
	 
	 public ThirdLevelDirectory selectThirdLevelDirectoryAndTypeTwo(@Param("id") Integer id);
	 
	 public ThirdLevelDirectory getDataByThirdName(@Param("thirdName")String thirdName);
	 
	 public List<ThirdLevelDirectory> selectThirdLevelDirectory();

}
