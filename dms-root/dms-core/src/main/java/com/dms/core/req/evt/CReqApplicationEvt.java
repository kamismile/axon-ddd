package com.dms.core.req.evt;

import java.util.UUID;

import com.dms.core.base.common.ddd.IdentifierModelWrapper;
import com.dms.core.inf.req.MReqApplication;

public class CReqApplicationEvt extends IdentifierModelWrapper<MReqApplication,String>{
	
	public CReqApplicationEvt(MReqApplication t) {
		super(t);
		t.setReqAppId(UUID.randomUUID().toString());
	}

}
