/**
 * 
 */
package com.fujitsu.ttf.yd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.Users;
import com.fujitsu.ttf.yd.mapper.UsersMapper;
import com.fujitsu.ttf.yd.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author wuyu
 *
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public void insertUsers(Users users) {
		usersMapper.insertUsers(users);
	}

	@Override
	public Users findUsersByOpenid(String openid) {
		return usersMapper.findUsersByOpenid(openid);
	}

	@Override
	public void UpdateUsers(Users users) {
		
		usersMapper.UpdateUsers(users);
	}

	@Override
	public Map<String,Object> getAllUsers(int page,int size) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageHelper.startPage(page, size);
		List<Users> list = usersMapper.findAllUsers();
		PageInfo<Users> entityPage = new PageInfo<Users>(list);
		resultMap.put("totalCount", entityPage.getTotal());
		resultMap.put("data", entityPage.getList());
		resultMap.put("page", page);
		resultMap.put("size", size);
		return resultMap;
	}

}
