/**
 * 
 */
package com.fujitsu.ttf.yd.service;

import java.util.List;

import com.fujitsu.ttf.yd.entity.HistorySearch;

/**
 * @Description
 * @author 吴雨
 * @date: 2019年12月14日 下午6:58:13
 */
public interface HistorySearchService {
    List<HistorySearch> getHistorySearch(String openid);
}
