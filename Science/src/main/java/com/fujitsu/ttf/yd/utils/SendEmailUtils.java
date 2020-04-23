/**
 * 
 */
package com.fujitsu.ttf.yd.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fujitsu.ttf.yd.entity.SendRecord;
import com.fujitsu.ttf.yd.service.SendRecordService;

/**
 * @author wuyu
 *
 */
@Component
public class SendEmailUtils {
	
	 private static SendRecordService sendRecordService;
	 
	
     public SendRecordService getSendRecordService() {
		return sendRecordService;
	 }

    @Autowired
	public void setSendRecordService(SendRecordService sendRecordService) {
    	SendEmailUtils.sendRecordService = sendRecordService;
	}


	public static void sendEmail(long pdfName,String targetAddress,String handbookName) {
    	 
    	String userName = "wuyu13276284262@163.com"; // 用户邮箱地址
 		String password = "wuyu194120"; // 密码或者授权码
 		//String targetAddress = null; // 接受者邮箱地址

 		// 设置邮件内容
 		MimeMessageDTO mimeDTO = new MimeMessageDTO();
 		mimeDTO.setSentDate(new Date());
 		mimeDTO.setSubject("Fujitsu");
 		mimeDTO.setText(targetAddress);
 		
 	    // 发送单邮件(附件)
		List<String> filepath=new ArrayList<String>();
		//filepath.add("D:/vuejs.pdf");
		filepath.add(Constants.MERGE_PATH+pdfName+".pdf");
//		if (MailUtil.sendEmailByFile(userName, password, targetAddress, mimeDTO,filepath)) {
//			System.out.println("邮件发送成功！");
//		} else {
//			System.out.println("邮件发送失败!!!");
//		}
		//targetAddress = "1308638159@qq.com,593548650@qq.com";
		if (MailUtil.sendGroupEmailByFile(userName, password, targetAddress, mimeDTO,filepath)) {
			System.out.println("邮件发送成功！");
			// 保存发送记录
			SendRecord sendRecord =new SendRecord();
			sendRecord.setSendEmail(targetAddress);
			sendRecord.setSendName(handbookName);
			// userId写死
			sendRecord.setUserId("1");
			
			 Date date = new Date();
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 String format = sdf.format(date);
			 sendRecord.setSendTime(Timestamp.valueOf(format));
			 System.err.println(sendRecord);
			 //new SendRecordServiceImpl().insertSendRecord(sendRecord);
			 System.out.println(sendRecordService);
			 sendRecordService.insertSendRecord(sendRecord);
		} else {
			System.out.println("邮件发送失败!!!");
		}
     }
}
