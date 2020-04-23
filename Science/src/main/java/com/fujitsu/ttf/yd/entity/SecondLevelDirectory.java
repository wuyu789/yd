/**
 * 
 */
package com.fujitsu.ttf.yd.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wuyu
 *
 */
@Setter
@Getter
public class SecondLevelDirectory {
    private Integer id;
    private String secondName;
    private String secondEnglishName;
    private Integer firstId;
    private String secondImg;
}
