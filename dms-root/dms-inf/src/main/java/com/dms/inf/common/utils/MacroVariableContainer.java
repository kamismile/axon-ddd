package com.dms.inf.common.utils;

/**
 * 
 * @author xhtian
 *
 */
public interface MacroVariableContainer {
	
	public void setMacroVariable(String name, Object value);

	public void removeMacroVariable(String name);

	public Object getMacroVariable(String name);
}
