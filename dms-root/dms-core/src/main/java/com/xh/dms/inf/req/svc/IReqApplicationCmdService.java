package com.xh.dms.inf.req.svc;

import com.xh.dms.inf.req.cmd.CReqApplicationCmd;
import com.xh.dms.inf.req.cmd.SubmitReqApplicationCmd;
import com.xh.dms.inf.req.cmd.UReqApplicationCmd;

//@Timeout(value = 3 ,unit = TimeUnit.MILLISECONDS)
public interface IReqApplicationCmdService {

	String create(CReqApplicationCmd cReqApplicationCmd);

	void update(UReqApplicationCmd uReqApplicationCmd) throws UnsupportedOperationException;

	void submit(SubmitReqApplicationCmd submitReqApplicationCmd) throws UnsupportedOperationException;

}
