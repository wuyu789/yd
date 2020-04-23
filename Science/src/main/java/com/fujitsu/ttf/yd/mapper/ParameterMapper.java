package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fujitsu.ttf.yd.entity.Parameter;

/**
*@author shik.jy
*@date 2019年10月21日
*@Description
*/
@Mapper
public interface ParameterMapper {

	List<Parameter> getAllParameter();
}
