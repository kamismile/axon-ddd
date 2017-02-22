package com.xh.dms.base.exception;


/**
 * 断言类,内部封装AppBizException
 * 
 * @author xhtian
 *
 */
public class Assert {

	/**
	 * 断言为真
	 * @param expression
	 * @param errorCode
	 * @throws AppBizException
	 */
	public static void isTrue(boolean expression,String errorCode) throws AppBizException{
		if(!expression){
			throw new AppBizException(errorCode);
		}
	}
	/**
	 * 断言为真
	 * @param expression
	 * @param errorCode
	 * @param msg
	 * @throws AppBizException
	 */
	public static void isTrue(boolean expression,String errorCode,String msg) throws AppBizException{
		if(!expression){
			throw new AppBizException(errorCode,msg);
		}
	}
	/**
	 * 断言为真
	 * @param expression
	 * @param errorCode
	 * @param msg
	 * @param args
	 * @throws AppBizException
	 */
	public static void isTrue(boolean expression,String errorCode,String msg,Object... args) throws AppBizException{
		if(!expression){
			throw new AppBizException(errorCode,msg,args);
		}
	}
}
