/**
 * 
 */
package com.fujitsu.ttf.yd.service;

import com.fujitsu.ttf.yd.entity.Collect;

/**
 * @author wuyu
 *
 */
public interface CollectService {
	public Collect selectCollect(String openid,Integer thirdId);
}
