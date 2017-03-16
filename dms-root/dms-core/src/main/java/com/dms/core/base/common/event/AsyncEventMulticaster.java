package com.dms.core.base.common.event;

import org.springframework.core.task.SimpleAsyncTaskExecutor;



/**
 * 异步事件组播
 * 
 * @author xhtian
 *
 */
public class AsyncEventMulticaster extends BasicEventMulticaster{
	
	public AsyncEventMulticaster(){
		setTaskExecutor(new SimpleAsyncTaskExecutor());
	}

}
