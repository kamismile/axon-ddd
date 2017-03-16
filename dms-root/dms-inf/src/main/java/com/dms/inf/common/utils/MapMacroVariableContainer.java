package com.dms.inf.common.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author xhtian
 *
 */
public class MapMacroVariableContainer implements MacroVariableContainer {
    private Map<String, Object> macroVariables = new HashMap<String, Object>();

    public MapMacroVariableContainer() {
    }

    public MapMacroVariableContainer(Map<String, Object> values) {
        this.macroVariables = values;
    }

    public void setMacroVariables(Map<String, Object> values) {
        if (values == null) {
            return;
        }

        macroVariables.putAll(values);
    }

    public void clear() {
        macroVariables.clear();
    }

    public void setMacroVariable(String name, Object value) {
        macroVariables.put(name, value);
    }

    public void removeMacroVariable(String name) {
        macroVariables.remove(name);
    }

    public Object getMacroVariable(String name) {
        return macroVariables.get(name);
    }
}