package com.xh.dms.core.req.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xh.dms.base.common.ddd.aggregate.BaseAnnotatedAggregateRoot;
import com.xh.dms.core.req.evt.CReqApplicationEvt;
import com.xh.dms.core.req.evt.SubmitReqApplicationEvt;
import com.xh.dms.core.req.evt.UReqApplicationEvt;
import com.xh.dms.inf.req.MReqApplication;
import com.xh.dms.inf.req.cmd.CReqApplicationCmd;
import com.xh.dms.inf.req.cmd.SubmitReqApplicationCmd;
import com.xh.dms.inf.req.cmd.UReqApplicationCmd;

/**
 * 需求申请
 * 
 * @author xhtian
 *
 */
public class ReqApplication extends BaseAnnotatedAggregateRoot<String>{
	
	private static Logger logger = LoggerFactory.getLogger(ReqApplication.class);
	
	private MReqApplication mReqApplication;
	
	public ReqApplication() {
		super();
	}

	@CommandHandler
	public ReqApplication(CReqApplicationCmd cmd) {
		apply(new CReqApplicationEvt(cmd.getModel()));
	}
	
	@CommandHandler
	public void updateDesc(UReqApplicationCmd cmd){
		apply(new UReqApplicationEvt(cmd.getModel()));
	}
	
	@CommandHandler
	public void submit(SubmitReqApplicationCmd cmd){
		apply(new SubmitReqApplicationEvt(cmd.getModel()));
	}
	
	/**
	 * 
	 * @param evt
	 * @see com.xh.dms.core.req.evd.ReqApplicationDtoEvd#cReqApplicationDto(CReqApplicationEvt)
	 */
	@EventSourcingHandler
	private void onCReqApplicationEvt(CReqApplicationEvt evt){
		setIdentifier(evt.getModel().identifier());
		this.mReqApplication = evt.getModel();
		logger.debug("created:[{}]" ,ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE));
	}
	
	/**
	 * 
	 * @param evt
	 * @see com.xh.dms.core.req.evd.ReqApplicationDtoEvd#uReqApplicationDto(UReqApplicationEvt)
	 */
	@EventSourcingHandler
	private void onUReqApplicationEvt(UReqApplicationEvt evt){
		if (mReqApplication.isState()) {
			throw new UnsupportedOperationException("u had submited.");
		}
		mReqApplication.setAppDescription(evt.getModel().getAppDescription());
		logger.debug("update:[{}]" , ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE));
	}
	
	/**
	 * 
	 * @param evt
	 * @see com.xh.dms.core.req.evd.ReqApplicationDtoEvd#submit(SubmitReqApplicationEvt)
	 * @see com.xh.dms.core.req.evd.SubmitReqApplicationEvdCreatChangeLog#createChangeLog(SubmitReqApplicationEvt)
	 */
	@EventSourcingHandler
	private void onSubmitReqApplicationEvt(SubmitReqApplicationEvt evt){
		if (mReqApplication.isState()) {
			throw new UnsupportedOperationException("u had submited.");
		}
		mReqApplication.setState(evt.getModel().isState());
		logger.debug("submit:[{}]" , ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE));
	}
	
}
