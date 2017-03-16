package com.dms.oauth.app.user.evd;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oauth.domain.user.evt.ChangePasswordEvt;
import com.dms.oauth.domain.user.evt.CreateUserEvt;
import com.dms.oauth.domain.user.evt.DeleteUserEvt;
import com.dms.oauth.domain.user.evt.UpdateUserEvt;
import com.dms.oauth.inf.user.view.UserView;
import com.dms.oauth.inf.user.view.UserViewRepository;

import net.sf.cglib.beans.BeanCopier;

@Component
public class UserViewEventHandler {
	
	@Autowired
	private UserViewRepository viewRepository;

	@EventHandler
	public void onCreated(CreateUserEvt evt){
		UserView userView = new UserView();
		BeanCopier beanCopier = BeanCopier.create(CreateUserEvt.class,UserView.class,false);
		beanCopier.copy(evt, userView, null);
		viewRepository.insert(userView);
	}
	
	@EventHandler
	public void onPwdChanged(ChangePasswordEvt evt){
		UserView userView = viewRepository.findOne(evt.getUserId());
		userView.setPwd(evt.getNewPassword());
		viewRepository.save(userView);
	}
	
	@EventHandler
	public void onUpdateUser(UpdateUserEvt evt){
		UserView userView = viewRepository.findOne(evt.getIdUser());
		BeanCopier beanCopier = BeanCopier.create(UpdateUserEvt.class,UserView.class,false);
		beanCopier.copy(evt, userView, null);
		viewRepository.save(userView);
	}
	
	@EventHandler
	public void onDeleteUser(DeleteUserEvt evt){
		viewRepository.delete(evt.getIdUser());
	}
}
