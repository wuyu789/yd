package com.fujitsu.ttf.yd.error;

import org.springframework.http.HttpStatus;

import com.fujitsu.ttf.yd.message.MessageManager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/** 状态码 */
	private HttpStatus status;

	/** 错误码 */
	private String code;

	/** 错误信息 */
	private String message;

	/**
	 * 异常构造方法
	 * 
	 * @param status 状态码
	 * @param code   错误码
	 * @param params 错误消息中的变量
	 */
	public AppException(HttpStatus status, String code, String... params) {
		this.status = status;
		this.code = code;
		this.message = MessageManager.getMessage(code, params);
	}

	public AppException(HttpStatus status) {
		this.status = status;
	}

}