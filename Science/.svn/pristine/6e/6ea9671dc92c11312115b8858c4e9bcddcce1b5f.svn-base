package com.fujitsu.ttf.yd.utils;

import com.fujitsu.ttf.yd.entity.ResultEntity;
import com.fujitsu.ttf.yd.enums.ResultEnum;

/**
 * @Author: 王冠
 * @Description: 生成返回值的工具类
 * @Modified By:
 */
public class ResultUtils {
    /**
     * 设置成功时的返回值
     *
     * @param object
     * @return
     */
    public static ResultEntity<Object> success(Object object) {
        ResultEntity<Object> resultEntity = new ResultEntity<Object>();
        resultEntity.setCode(ResultEnum.SUCCESS.getCode());
        resultEntity.setMsg(ResultEnum.SUCCESS.getMsg());
        resultEntity.setData(object);
        return resultEntity;
    }


    public static ResultEntity<Object> error(Integer code, String msg){
        ResultEntity<Object> resultEntity =new ResultEntity<Object>();
        resultEntity.setCode(code);
        resultEntity.setMsg(msg);
        return resultEntity;
    }

    public static ResultEntity<Object> success() {
        ResultEntity<Object> resultEntity = new ResultEntity<Object>();
        resultEntity.setCode(ResultEnum.SUCCESS.getCode());
        resultEntity.setMsg(ResultEnum.SUCCESS.getMsg());
        return resultEntity;
    }
}
