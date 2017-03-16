package com.dms.core.req.evd;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.core.inf.req.MReqApplication;
import com.dms.core.inf.req.dto.ReqApplicationDto;
import com.dms.core.inf.req.dto.ReqApplicationDtoMongoRepository;
import com.dms.core.req.evt.CReqApplicationEvt;
import com.dms.core.req.evt.SubmitReqApplicationEvt;
import com.dms.core.req.evt.UReqApplicationEvt;

import net.sf.cglib.beans.BeanCopier;

@Component
public class ReqApplicationDtoEvd {
	
	private static Logger logger = LoggerFactory.getLogger(ReqApplicationDtoEvd.class);
	
	@Autowired
	private ReqApplicationDtoMongoRepository dtoMongoRepository;

	@EventHandler
	public void cReqApplicationDto(CReqApplicationEvt evt){
		ReqApplicationDto reqApplicationDto = new ReqApplicationDto();
		BeanCopier beanCopier = BeanCopier.create(MReqApplication.class,ReqApplicationDto.class,false);
		beanCopier.copy(evt.getModel(), reqApplicationDto, null);
		dtoMongoRepository.insert(reqApplicationDto);
		logger.debug("created dto:[{}]" ,ReflectionToStringBuilder.toString(reqApplicationDto, ToStringStyle.SHORT_PREFIX_STYLE));
	} 
	
	@EventHandler
	public void uReqApplicationDto(UReqApplicationEvt evt){
		ReqApplicationDto reqApplicationDto = dtoMongoRepository.findOne(evt.identifier());
		reqApplicationDto.setAppDescription(evt.getModel().getAppDescription());
		dtoMongoRepository.save(reqApplicationDto);
		logger.debug("update dto:[{}]" ,ReflectionToStringBuilder.toString(reqApplicationDto, ToStringStyle.SHORT_PREFIX_STYLE));
	} 
	
	@EventHandler
	public void submit(SubmitReqApplicationEvt evt){
		ReqApplicationDto reqApplicationDto = dtoMongoRepository.findOne(evt.identifier());
		reqApplicationDto.setState(evt.getModel().isState());
		dtoMongoRepository.save(reqApplicationDto);
		logger.debug("submit dto:[{}]" ,ReflectionToStringBuilder.toString(reqApplicationDto, ToStringStyle.SHORT_PREFIX_STYLE));
	} 
}
