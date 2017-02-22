package com.xh.dms.base.common.ddd;

import java.io.Serializable;

public interface IdentifierModel<T,I extends Serializable> extends Identifier<I>{

	public T getModel();
}
