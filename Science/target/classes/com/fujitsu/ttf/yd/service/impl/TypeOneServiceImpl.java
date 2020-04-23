package com.fujitsu.ttf.yd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.TypeOne;
import com.fujitsu.ttf.yd.mapper.TypeOneMapper;
import com.fujitsu.ttf.yd.service.TypeOneService;

/**
 * @author wuyu
 *
 */
@Service
public class TypeOneServiceImpl implements TypeOneService {

	@Autowired
	private TypeOneMapper typeOneMapper;
	
	@Override
	public TypeOne selectTypeOneById(Integer id) {
		return typeOneMapper.selectTypeOneById(id);
	}

}
