/*** Copyright © 2012 HandPay Information Technology ( Group ) Co., Ltd. */
package com.dms.core.base.common.utils;

/**
 * <a href="PageUtil.java.html"><b><i>View Source</i></b></a>
 * 
 * Description ★ 分页参数设置
 * 
 * @author zhcui
 */
public class PageUtil {

	/** 页码 */
	private Long page;

	/** 每页显示的记录数 */
	private Long pageSize;

	public PageUtil(Long page, Long pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	/**
	 * 获取起始的记录序号
	 * 
	 * @return
	 */
	public Long getBeginNum() {
		return pageSize * page - pageSize;
	}

	/**
	 * 获取的记录序号
	 * 
	 * @return
	 */
	public Long getEndNum() {
		return pageSize * page;
	}

}
