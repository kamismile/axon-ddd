/*** Copyright © 2001-2010 HandPay Information Technology ( Group ) Co., Ltd. */
package com.xh.dms.base.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ListSplitUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * Description ★ List 拆分工具类
 * 
 * @author zhcui
 */
public class ListSplitUtil {

	/**
	 * List分割
	 * 
	 * @param sourceList
	 *            原列表
	 * @param spliTotal
	 *            拆分条数
	 * @return
	 */
	public static <T> List<List<T>> splitList(List<T> sourceList, int spliTotal) {

		List<List<T>> resultList = new ArrayList<List<T>>();

		int pagesize = spliTotal;

		int totalcount = sourceList.size();

		int pagecount = 0;

		int m = totalcount % pagesize;

		if (m > 0) {
			pagecount = totalcount / pagesize + 1;
		} else {
			pagecount = totalcount / pagesize;
		}

		for (int i = 1; i <= pagecount; i++) {
			if (m == 0) {
				List<T> subList = sourceList.subList((i - 1) * pagesize, pagesize * (i));
				resultList.add(subList);
			} else {
				if (i == pagecount) {
					List<T> subList = sourceList.subList((i - 1) * pagesize, totalcount);
					resultList.add(subList);
				} else {
					List<T> subList = sourceList.subList((i - 1) * pagesize, pagesize * (i));
					resultList.add(subList);
				}
			}
		}

		return resultList;
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		for (int i = 1; i < 101; i++) {
			list.add("" + i);
		}

		System.out.println(splitList(list, 30));

	}
}