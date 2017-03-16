package com.dms.core.changelog.svc;

import com.dms.core.changelog.cmd.CReqAppChangeLogCmd;

public interface IReqAppChangeLogService {

	void cReqAppChangeLog(CReqAppChangeLogCmd cmd);
}
