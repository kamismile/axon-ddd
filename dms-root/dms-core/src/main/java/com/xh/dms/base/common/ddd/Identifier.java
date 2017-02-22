package com.xh.dms.base.common.ddd;

import java.io.Serializable;

public interface Identifier<I extends Serializable> {
	
	public I identifier();
	
}
