/**
 * 
 */
package com.fujitsu.ttf.yd.service;

import java.util.Map;

import com.fujitsu.ttf.yd.entity.Users;

/**
 * @author wuyu
 *
 */
public interface UsersService {
	
	public void insertUsers(Users users);
	
	public Users findUsersByOpenid(String openid);
	
	public void UpdateUsers(Users users);

	public Map<String,Object> getAllUsers(int page,int size);
}
