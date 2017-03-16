package com.dms.core.req.evt;

import com.dms.core.base.common.ddd.IdentifierModelWrapper;
import com.dms.core.inf.req.MReqApplication;

public class UReqApplicationEvt extends IdentifierModelWrapper<MReqApplication,String>{

	public UReqApplicationEvt(MReqApplication t) {
		super(t);
	}
}
