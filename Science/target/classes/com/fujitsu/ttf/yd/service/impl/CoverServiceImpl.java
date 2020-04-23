/**
 * 
 */
package com.fujitsu.ttf.yd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.Cover;
import com.fujitsu.ttf.yd.mapper.CoverMapper;
import com.fujitsu.ttf.yd.service.CoverService;

/**
 * @author wuyu
 *
 */
@Service
public class CoverServiceImpl implements CoverService {

	@Autowired
	private CoverMapper coverMapper;
	
	@Override
	public List<Cover> getAllCover() {
		List<Cover> list=coverMapper.getAllCover();
		List<Cover> coverList=new ArrayList<Cover>();
		for(int i=0;i<list.size();i++) {
			Cover cover=new Cover();
			cover.setId(list.get(i).getId());
			cover.setCoverName("/cover/"+list.get(i).getCoverName());
			cover.setCoverUrl(list.get(i).getCoverUrl());
			coverList.add(cover);
		}
		return coverList;
	}

}
