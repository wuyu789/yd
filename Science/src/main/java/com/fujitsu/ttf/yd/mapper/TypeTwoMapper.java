/**
 * 
 */
package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fujitsu.ttf.yd.entity.TypeOne;
import com.fujitsu.ttf.yd.entity.TypeTwo;

/**
 * @author wuyu
 *
 */
@Mapper
public interface TypeTwoMapper {
	
	public TypeTwo selectTypeTwoById(@Param("id")Integer id);
	
	public List<TypeTwo> getAllTypeTwo(TypeTwo typetwo);
	
	public List<TypeTwo> getDataByProductName(@Param("productName")String productName);
}
