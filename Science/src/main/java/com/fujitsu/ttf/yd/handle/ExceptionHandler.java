package com.fujitsu.ttf.yd.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujitsu.ttf.yd.entity.ResultEntity;
import com.fujitsu.ttf.yd.enums.ResultEnum;
import com.fujitsu.ttf.yd.exception.ErrorException;
import com.fujitsu.ttf.yd.utils.ResultUtils;

/**
 * @Author: 王冠
 * @Description: 处理异常类
 * @Modified By:
 */
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity<Object> handle(Exception e){
        if(e instanceof ErrorException){
            ErrorException errorHandle=(ErrorException)e;
            return ResultUtils.error(errorHandle.getCode(),e.getMessage());
        }else{
            return ResultUtils.error(ResultEnum.UN_KNOW_ERROR.getCode(),ResultEnum.UN_KNOW_ERROR.getMsg());
        }
    }
}
