package com.fujitsu.ttf.yd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.Carousel;
import com.fujitsu.ttf.yd.mapper.CarouselMapper;
import com.fujitsu.ttf.yd.service.CarouselService;

/**
 * @author wuyu
 *
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    
	@Autowired
	private CarouselMapper carouselMapper;
	
	@Override
	public List<Carousel> getAllCarouselVo() {
		List<Carousel> list=carouselMapper.getAllCarouselVo();
		List<Carousel> carouselList=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			Carousel carousel=new Carousel();
			carousel.setId(list.get(i).getId());
			carousel.setCarouselName("/carousel/"+list.get(i).getCarouselName());
			carousel.setCarouselUrl(list.get(i).getCarouselUrl());
			carouselList.add(carousel);
		}
		return carouselList;
	}

}
