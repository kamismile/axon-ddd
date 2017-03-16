package com.dms.core.req.evt;

import com.dms.core.base.common.ddd.IdentifierModelWrapper;
import com.dms.core.inf.req.MReqApplication;

public class SubmitReqApplicationEvt extends IdentifierModelWrapper<MReqApplication,String>{

	public SubmitReqApplicationEvt(MReqApplication t) {
		super(t);
		t.setState(true);
	}

	
}
