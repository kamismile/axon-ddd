package com.dms.core.req.saga;

public class ReqAppDeadlineExpiredEvt {

	private String reqAppId;

	public ReqAppDeadlineExpiredEvt(String reqAppId) {
		super();
		this.reqAppId = reqAppId;
	}

	public String getReqAppId() {
		return reqAppId;
	}
}
