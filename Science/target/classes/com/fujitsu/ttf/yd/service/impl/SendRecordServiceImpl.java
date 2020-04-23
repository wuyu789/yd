package com.fujitsu.ttf.yd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujitsu.ttf.yd.entity.SendRecord;
import com.fujitsu.ttf.yd.mapper.SendRecordMapper;
import com.fujitsu.ttf.yd.service.SendRecordService;

/**
 * @author wuyu
 *
 */
@Service
public class SendRecordServiceImpl implements SendRecordService {

	@Autowired
	private SendRecordMapper sendRecordMapper;
	
	@Override
	public void insertSendRecord(SendRecord sendRecord) {
		 sendRecordMapper.insertSendRecord(sendRecord);
		 
	}
	@Override
	public List<SendRecord> selectSendRecordByUserId(String openid) {
		return sendRecordMapper.selectSendRecordByUserId(openid);
	}

}
