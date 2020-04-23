package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fujitsu.ttf.yd.entity.SecondLevelDirectory;

/**
 * @author wuyu
 *
 */
@Mapper
public interface SecondLevelDirectoryMapper {
	
	 public List<SecondLevelDirectory> getAllSecondDirectoryByFirstId(@Param("firstId")Integer firstId);
}
