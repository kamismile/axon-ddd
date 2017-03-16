package com.dms.core.base.common.event;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * 事件组播——基于同步实现
 * 
 * @author xhtian
 * 
 */
public class BasicEventMulticaster extends SimpleApplicationEventMulticaster {

	private List<ApplicationListener> listeners = new LinkedList<ApplicationListener>();

	/**
	 * @param listeners
	 *            the listeners to set
	 */
	public void setListeners(List<ApplicationListener> listeners) {
		this.listeners = listeners;
		for (ApplicationListener applicationListener : listeners) {
			addApplicationListener(applicationListener);
		}
	}

}
