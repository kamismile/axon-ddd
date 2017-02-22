package com.xh.dms.web.req.cmd;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.dms.core.req.ReqConfiguration;
import com.xh.dms.core.req.model.ReqApplication;
import com.xh.dms.inf.req.MReqApplication;
import com.xh.dms.inf.req.cmd.CReqApplicationCmd;
import com.xh.dms.inf.req.cmd.SubmitReqApplicationCmd;
import com.xh.dms.inf.req.cmd.UReqApplicationCmd;
import com.xh.dms.inf.req.svc.IReqApplicationCmdService;

@RestController    
@RequestMapping("/reqApp") 
public class ReqApplicationCmdController {
	
	@Autowired
	private IReqApplicationCmdService reqApplicationService;

	@RequestMapping(value = "/create:{desc},{idMember},{idDepartment}")
	public String create(@PathVariable("desc") String desc,@PathVariable("idMember") String idMember,@PathVariable("idDepartment") String idDepartment){
		String id = UUID.randomUUID().toString();
		MReqApplication mReqApplication = new MReqApplication();
		mReqApplication.setAppDescription(desc);
		mReqApplication.setCreateTime(new Date());
		mReqApplication.setIdDepartment(idDepartment);
		mReqApplication.setIdMember(idMember);
		CReqApplicationCmd cReqApplicationCmd = new CReqApplicationCmd(mReqApplication);
		String idReqApp = reqApplicationService.create(cReqApplicationCmd);
		System.out.println("ai you");
		return idReqApp;
	}
	
	@RequestMapping(value = "/update:{idReqApp},{desc}")
	public String update(@PathVariable("idReqApp") String idReqApp,@PathVariable("desc") String desc){
		MReqApplication mReqApplication = new MReqApplication();
		mReqApplication.setReqAppId(idReqApp);
		mReqApplication.setAppDescription(desc);
		UReqApplicationCmd uReqApplicationCmd = new UReqApplicationCmd(mReqApplication);
		reqApplicationService.update(uReqApplicationCmd);
		return desc;
	}
	
	@RequestMapping(value = "/submit:{idReqApp}")
	public String submit(@PathVariable("idReqApp") String idReqApp){
		MReqApplication mReqApplication = new MReqApplication();
		mReqApplication.setReqAppId(idReqApp);
		SubmitReqApplicationCmd submitReqApplicationCmd = new SubmitReqApplicationCmd(mReqApplication);
		reqApplicationService.submit(submitReqApplicationCmd);
		return idReqApp;
	}
}
