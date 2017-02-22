package com.xh.dms.core.req.evt;

import com.xh.dms.base.common.ddd.IdentifierModelWrapper;
import com.xh.dms.inf.req.MReqApplication;

public class UReqApplicationEvt extends IdentifierModelWrapper<MReqApplication,String>{

	public UReqApplicationEvt(MReqApplication t) {
		super(t);
	}
}
