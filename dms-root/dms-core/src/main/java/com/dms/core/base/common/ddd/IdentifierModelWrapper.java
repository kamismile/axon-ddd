package com.dms.core.base.common.ddd;

import java.io.Serializable;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public abstract class IdentifierModelWrapper<T,I extends Serializable> implements IdentifierModel<T,I>{

	protected T t;

	public IdentifierModelWrapper(T t){
		this.t = t;
	}
	@Override
	public T getModel() {
		return t;
	}
	
	@Override
	@TargetAggregateIdentifier
	public I identifier() {
		return ((Identifier<I>) t).identifier();
	}

}
