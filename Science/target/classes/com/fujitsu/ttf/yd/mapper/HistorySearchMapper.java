/**
 * 
 */
package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fujitsu.ttf.yd.entity.HistorySearch;

/**
 * @Description
 * @author 吴雨
 * @date: 2019年12月14日 下午6:47:51
 */
@Mapper
public interface HistorySearchMapper {
     public void insertData(HistorySearch historySearch);
     
     public List<HistorySearch> getHistorySearch(@Param("openid")String openid);
}
