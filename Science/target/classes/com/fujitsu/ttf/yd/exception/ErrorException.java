package com.fujitsu.ttf.yd.exception;


import com.fujitsu.ttf.yd.enums.ResultEnum;

/**
 * @Author: 王冠
 * @Description: 手动抛出的异常
 * @Modified By:
 */
public class ErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private Integer code;

    public ErrorException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
