/**
 * 
 */
package com.fujitsu.ttf.yd.entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wuyu
 *
 */
@Setter
@Getter
@Table(name = "type_2")
public class TypeTwo {
    private Integer id;
    private String productName;
    private String partNumber;
    private String hoseId;
    private String wpMpa;
    private String spiralOrBraid;
    private Integer lowestTemperature;
    private Integer highestTemperature;
}
