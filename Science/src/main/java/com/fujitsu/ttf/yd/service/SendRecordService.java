/**
 * 
 */
package com.fujitsu.ttf.yd.service;

import java.util.List;

import com.fujitsu.ttf.yd.entity.SendRecord;

/**
 * @author wuyu
 *
 */
public interface SendRecordService {
	public void insertSendRecord(SendRecord sendRecord);
	
	public List<SendRecord> selectSendRecordByUserId(String openid);
}
