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
public class ThirdLevelDirectory {
      private Integer id;
      private Integer secondId;
      private String thirdName;
      private String title;
      private String describe;
      private String thirdImg;
      private Integer typeId;
      private String pdfName;
      private Integer isCollect;
      private TypeOne typeOne;
      private TypeTwo typeTwo;
      private Integer collectCount;
      private String productName;
      private String pdfImg;
      private Integer clickNum;
      private Integer downloadNum;
      private String partNumber;
      private String hoseId;
      private String hoseOd;
      private String wpPsi;
      private String lowestTemperature;
      private String highestTemperature;
      private String classification;
      private String medium;
      private String wpMpa;
      private String spiralOrBraid;
      private String secondArray;
}
