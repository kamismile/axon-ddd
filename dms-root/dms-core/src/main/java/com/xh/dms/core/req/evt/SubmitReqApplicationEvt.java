package com.xh.dms.core.req.evt;

import com.xh.dms.base.common.ddd.IdentifierModelWrapper;
import com.xh.dms.inf.req.MReqApplication;

public class SubmitReqApplicationEvt extends IdentifierModelWrapper<MReqApplication,String>{

	public SubmitReqApplicationEvt(MReqApplication t) {
		super(t);
		t.setState(true);
	}

	
}
