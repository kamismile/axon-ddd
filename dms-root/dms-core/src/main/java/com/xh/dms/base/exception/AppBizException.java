package com.xh.dms.base.exception;

import java.util.Map;
import java.util.TreeMap;

import com.xh.dms.base.common.utils.MacroVariableInterpreter;
import com.xh.dms.base.common.utils.MapMacroVariableContainer;


/**
 * 业务异常类
 * 
 * @author xhtian
 *
 */
public class AppBizException extends Exception {
	
	public static final long serialVersionUID = 0x01;

	/**
	 * 应用异常码
	 */
	private String code;

	/**
	 * 应用异常描述参数
	 */
	private Object[] args;

	/**
	 * 文本消息
	 */
	private String textMessage;

	private static String formatMessage(String msg, Object[] args) {
		if (args == null){
			return msg;
		}
		Map<String, Object> map = new TreeMap<String, Object>();
		for (int i = 0; i < args.length; i++) {
			map.put(String.valueOf(i), args[i]);
		}

		MapMacroVariableContainer mvc = new MapMacroVariableContainer(map);
		return MacroVariableInterpreter.interpret(msg, "{", "}", mvc);
	}

	public AppBizException(String code) {
		super(code);
		this.code = code;
	}
	
	public AppBizException(String code, String msg) {
		super(code + ": " + msg);
		this.code = code;
	}

	public AppBizException(String code, String msg, Throwable cause) {
		super(code + ": " + msg, cause);
		this.code = code;
	}


	public AppBizException(String code, String msg, Object... args) {
		super(code + ": " + formatMessage(msg, args));
		this.code = code;
		this.args = args;
	}

	public AppBizException(String code, Throwable cause, String msg, Object... args) {
		super(code + ": " + formatMessage(msg, args), cause);
		this.code = code;
		this.args = args;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String string) {
		code = string;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] objects) {
		args = objects;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

}
