package com.xh.dms.base.common.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.xh.dms.base.exception.AppBizException;

/**
 * AsyncTaskExecutor 基于JDK ExecutorService的简单实现
 * @author xhtian
 *
 */
public class SimpleAsyncTaskExecutor implements IAsyncTaskExecutor {

	private static final long DEFAULT_TIMEOUT = 30;

	private ExecutorService executor = Executors.newCachedThreadPool();

	private long timeout = DEFAULT_TIMEOUT;

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	@Override
	public <T> T execute(AsyncTaskCallBack<T> callBack) throws AppBizException {
		Future<T> future = doExecute(callBack);
		try {
			return future.get(timeout, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new AppBizException("E-BASE-100", e, "Async Interrupted Error.");
		} catch (ExecutionException e) {
			throw new AppBizException("E-BASE-101", e, "Async Execution Error.");
		} catch (TimeoutException e) {
			throw new AppBizException("E-BASE-102", e, "Async Invork Timeout.");
		}
	}

	@Override
	public void exeWithoutResult(AsyncTaskCallBack<Object> callBack) throws AppBizException {
		doExecute(callBack);
	}

	protected <T> Future<T> doExecute(final AsyncTaskCallBack<T> callBack) {
		return executor.submit(new Callable<T>() {
			@Override
			public T call() throws Exception {
				return callBack.invork();
			}
		});
	}
}
