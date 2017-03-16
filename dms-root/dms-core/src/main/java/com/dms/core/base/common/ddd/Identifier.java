package com.dms.core.base.common.ddd;

import java.io.Serializable;

public interface Identifier<I extends Serializable> {
	
	public I identifier();
	
}
