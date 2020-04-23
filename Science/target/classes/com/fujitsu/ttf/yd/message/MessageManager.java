package com.fujitsu.ttf.yd.message;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class MessageManager {

    /** 资源文件 */
    private static ResourceBundle messageBundle;

    /** 变量前缀 */
    private static final String PREFIX = "$";

    /**
     * 获取消息码对应的消息
     * @param msgCode 消息码
     * @param params 消息中的参数
     * @return String 对应的消息
     */
    public static String getMessage(String msgCode, String... params) {
        if (null == messageBundle) {
            messageBundle = ResourceBundle.getBundle("message");
        }
        String msg;
        try {
            msg = messageBundle.getString(msgCode);
        } catch(MissingResourceException missExp) {
            msg = "messageCode " + msgCode + " is not defined in error message file";
        }
        for (int i = 0; i < params.length; i++) {
            msg = StringUtils.replace(msg, PREFIX + i, params[i]);
        }
        return msg;
    }

}