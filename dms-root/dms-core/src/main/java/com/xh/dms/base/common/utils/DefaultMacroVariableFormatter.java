package com.xh.dms.base.common.utils;



/**
 * 
 * @author xhtian
 *
 */
public class DefaultMacroVariableFormatter implements MacroVariableFormatter {
    public String format(String pattern, Object value) {
        return StringFormat.toString(pattern, value);
    }

}
