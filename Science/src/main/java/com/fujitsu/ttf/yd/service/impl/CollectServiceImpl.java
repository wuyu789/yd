/**
 * 
 */
package com.fujitsu.ttf.yd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.Collect;
import com.fujitsu.ttf.yd.mapper.CollectMapper;
import com.fujitsu.ttf.yd.service.CollectService;

/**
 * @author wuyu
 *
 */
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectMapper collectMapper;
	
	@Override
	public Collect selectCollect(String openid, Integer thirdId) {
		
		return collectMapper.selectCollect(openid, thirdId);
	}

}
