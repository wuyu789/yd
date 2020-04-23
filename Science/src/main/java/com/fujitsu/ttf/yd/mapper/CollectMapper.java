/**
 * 
 */
package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fujitsu.ttf.yd.entity.Collect;

/**
 * @author wuyu
 *
 */
@Mapper
public interface CollectMapper {
     public Collect selectCollect(@Param("openid")String openid,@Param("thirdId")Integer thirdId);
     
     public List<Collect> selectCollectThirdId(@Param("openid")String openid);
}
