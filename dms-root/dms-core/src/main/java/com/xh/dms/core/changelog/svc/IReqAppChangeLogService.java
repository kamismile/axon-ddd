package com.xh.dms.core.changelog.svc;

import com.xh.dms.core.changelog.cmd.CReqAppChangeLogCmd;

public interface IReqAppChangeLogService {

	void cReqAppChangeLog(CReqAppChangeLogCmd cmd);
}
