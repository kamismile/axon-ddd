package com.xh.dms.core.req.evt;

import java.util.UUID;

import com.xh.dms.base.common.ddd.IdentifierModelWrapper;
import com.xh.dms.inf.req.MReqApplication;

public class CReqApplicationEvt extends IdentifierModelWrapper<MReqApplication,String>{
	
	public CReqApplicationEvt(MReqApplication t) {
		super(t);
		t.setReqAppId(UUID.randomUUID().toString());
	}

}
