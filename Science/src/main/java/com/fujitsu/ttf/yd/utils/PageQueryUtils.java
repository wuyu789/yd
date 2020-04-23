package com.fujitsu.ttf.yd.utils;

import java.util.stream.IntStream;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
* @ClassName: PageQueryUtils 
* @Description: 分页方法校验公共类
* @author shik.jy
* @date 2019年10月11日 下午6:05:03 
*
 */

@Getter
public class PageQueryUtils {
    
    @ApiModelProperty(hidden = true)
    private int[] sizeArray = {10, 20, 30, 40, 50};

    @ApiModelProperty(value = "每页大小(限定值：10,20,30,40,50)", required = false)
    public int size = 10;

    @ApiModelProperty(value = "显示第几页", required = false)
    public int page = 0;
    
    public void setSize(int size) {
        if (IntStream.of(sizeArray).anyMatch(val -> val == size)) {
            this.size = size;
        }
    }

    public void setPage(int page) {
        if (page > 0) {
            this.page = page;
        }
    }
}
