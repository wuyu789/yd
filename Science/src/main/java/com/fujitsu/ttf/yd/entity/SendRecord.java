/**
 * 
 */
package com.fujitsu.ttf.yd.entity;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wuyu
 *
 */
@Setter
@Getter
public class SendRecord {
    private Integer id;
    private String sendName;
    private Timestamp sendTime;
    private String sendEmail;
    private String userId;
}
