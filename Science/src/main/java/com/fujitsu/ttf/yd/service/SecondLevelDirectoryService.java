/**
 * 
 */
package com.fujitsu.ttf.yd.service;

import java.util.List;

import com.fujitsu.ttf.yd.entity.SecondLevelDirectory;

/**
 * @author wuyu
 *
 */
public interface SecondLevelDirectoryService {
	public List<SecondLevelDirectory> getAllSecondDirectoryByFirstId(Integer firstId);
}
