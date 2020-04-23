/**
 * 
 */
package com.fujitsu.ttf.yd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.FirstLevelDirectory;
import com.fujitsu.ttf.yd.mapper.FirstLevelDirectoryMapper;
import com.fujitsu.ttf.yd.service.FirstLevelDirectoryService;

/**
 * @author wuyu
 *
 */
@Service
public class FirstLevelDirectoryServiceImpl implements FirstLevelDirectoryService {

	@Autowired
	private FirstLevelDirectoryMapper firstLevelDirectoryMapper;
	
	@Override
	public List<FirstLevelDirectory> getAllDirectory() {
		
		return firstLevelDirectoryMapper.getAllDirectory();
	}

}
