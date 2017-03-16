package com.dms.core.inf.req.svc;

import com.dms.core.inf.req.cmd.CReqApplicationCmd;
import com.dms.core.inf.req.cmd.SubmitReqApplicationCmd;
import com.dms.core.inf.req.cmd.UReqApplicationCmd;

//@Timeout(value = 3 ,unit = TimeUnit.MILLISECONDS)
public interface IReqApplicationCmdService {

	String create(CReqApplicationCmd cReqApplicationCmd);

	void update(UReqApplicationCmd uReqApplicationCmd) throws UnsupportedOperationException;

	void submit(SubmitReqApplicationCmd submitReqApplicationCmd) throws UnsupportedOperationException;

}
