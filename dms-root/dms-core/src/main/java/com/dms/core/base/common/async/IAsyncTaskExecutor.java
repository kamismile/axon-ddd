package com.dms.core.base.common.async;

import com.dms.core.base.exception.AppBizException;

/**
 * 异步任务执行器
 * 
 * @author xhtian
 * 
 * @param <T>
 */
public interface IAsyncTaskExecutor {

	/**
	 * 执行异步调用——有返回值
	 * 
	 * @param callBack
	 * @return
	 * @throws AppBizException
	 */
	<T> T execute(AsyncTaskCallBack<T> callBack) throws AppBizException;

	/**
	 * 执行异步调用——无返回值
	 * 
	 * @param callBack
	 * @throws AppBizException
	 */
	void exeWithoutResult(AsyncTaskCallBack<Object> callBack) throws AppBizException;

	/**
	 * 异步任务回调接口
	 * 
	 * @author xhtian
	 * 
	 * @param <T>
	 */
	public interface AsyncTaskCallBack<T> {
		/**
		 * 执行业务调用
		 * 
		 * @return
		 * @throws AppBizException
		 */
		public T invork() throws AppBizException;
	}

}
