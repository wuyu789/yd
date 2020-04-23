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
@Table(name = "type_1")
public class TypeOne {
    private Integer id;
    private String productName;
    private String hoseId;
    private String hoseOd;
    private String wpPsi;
    private Integer lowestTemperature;
    private Integer highestTemperature;
    private String classification;
    private String medium;
}
