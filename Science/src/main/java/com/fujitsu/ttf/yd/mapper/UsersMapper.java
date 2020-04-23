/**
 * 
 */
package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fujitsu.ttf.yd.entity.Users;

/**
 * @author wuyu
 *
 */
@Mapper
public interface UsersMapper {
    public void insertUsers(Users users);
    
    public Users findUsersByOpenid(@Param("openid")String openid);
    
    public void UpdateUsers(Users users);
    
    public List<Users> findAllUsers();
}
