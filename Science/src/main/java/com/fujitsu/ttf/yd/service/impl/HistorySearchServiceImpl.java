/**
 * 
 */
package com.fujitsu.ttf.yd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.HistorySearch;
import com.fujitsu.ttf.yd.mapper.HistorySearchMapper;
import com.fujitsu.ttf.yd.service.HistorySearchService;

/**
 * @Description
 * @author 吴雨
 * @date: 2019年12月14日 下午6:58:55
 */
@Service
public class HistorySearchServiceImpl implements HistorySearchService {

	@Autowired
	private HistorySearchMapper historySearchMapper;
	
	@Override
	public List<HistorySearch> getHistorySearch(String openid) {
		
		return historySearchMapper.getHistorySearch(openid);
	}

}
