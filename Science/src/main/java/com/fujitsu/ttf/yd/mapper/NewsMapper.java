package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fujitsu.ttf.yd.entity.News;

/**
 * @author wuyu
 *
 */
@Mapper
public interface NewsMapper {
	
     public List<News> getAllNews();
}
