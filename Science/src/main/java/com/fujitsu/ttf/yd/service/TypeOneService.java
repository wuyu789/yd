/**
 * 
 */
package com.fujitsu.ttf.yd.service;

import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.TypeOne;

/**
 * @author wuyu
 *
 */
@Service
public interface TypeOneService {
	public TypeOne selectTypeOneById(Integer id);
}
