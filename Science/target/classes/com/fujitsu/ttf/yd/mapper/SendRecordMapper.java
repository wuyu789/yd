/**
 * 
 */
package com.fujitsu.ttf.yd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fujitsu.ttf.yd.entity.SendRecord;

/**
 * @author wuyu
 *
 */
@Mapper
public interface SendRecordMapper {
     public void insertSendRecord(SendRecord sendRecord);
     
     public List<SendRecord> selectSendRecordByUserId(@Param("openid")String openid);
}
