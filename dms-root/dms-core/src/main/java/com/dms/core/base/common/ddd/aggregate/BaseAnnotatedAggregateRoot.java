package com.dms.core.base.common.ddd.aggregate;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public abstract class BaseAnnotatedAggregateRoot<I> extends AbstractAnnotatedAggregateRoot<I> {
	
	@AggregateIdentifier
	private I identifier;

	public void setIdentifier(I identifier) {
		this.identifier = identifier;
	}
	
	
}
