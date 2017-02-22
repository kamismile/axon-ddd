package com.xh.dms.base.common.ddd;

public interface CommandEvent {

	<C,E> E createEvt(C c,E e);
}
