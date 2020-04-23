package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fujitsu.ttf.yd.entity.Carousel;

/**
 * @author wuyu
 *
 */
@Mapper
public interface CarouselMapper {
	
	public List<Carousel> getAllCarouselVo();
}
