/**
 * 
 */
package com.fujitsu.ttf.yd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.News;
import com.fujitsu.ttf.yd.mapper.NewsMapper;
import com.fujitsu.ttf.yd.service.NewsService;

/**
 * @author wuyu
 *
 */
@Service
public class NewsServiceImpl implements NewsService {
    
	
	@Autowired
	private NewsMapper newsMapper;
	
	/**
	 * @Description: 获取所有新闻信息
	 */
	@Override
	public List<News> getAllNews() {
		List<News> list=newsMapper.getAllNews();
		List<News> newsList=new ArrayList<News>();
		for(int i=0;i<list.size();i++) {
			News news=new News();
			news.setId(list.get(i).getId());
			news.setNewsName("/news/"+list.get(i).getNewsName());
			news.setNewsUrl(list.get(i).getNewsUrl());
			newsList.add(news);
		}
		return newsList;
	}

}
