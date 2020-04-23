package com.fujitsu.ttf.yd.vo.management;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
*@author shik.jy
*@date 2019年11月21日
*@Description 三级目录级下拉框前台传值对象
*/
@Data
public class ProductVo {

	@ApiModelProperty(value = "搜索条件key", required = false)
	private List<String> keys;
	
	@ApiModelProperty(value = "搜索条件value", required = false)
	private List<String> values;
	
	@ApiModelProperty(value = "页码", required = false)
	private int page;
	
	@ApiModelProperty(value = "页数", required = false)
	private int size;
	
	@ApiModelProperty(value = "二级目录id", required = false)
	private int secondId;
}
