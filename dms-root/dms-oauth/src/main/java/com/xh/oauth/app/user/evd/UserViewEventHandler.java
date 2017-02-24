package com.xh.oauth.app.user.evd;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xh.oauth.domain.user.evt.ChangePasswordEvt;
import com.xh.oauth.domain.user.evt.CreateUserEvt;
import com.xh.oauth.domain.user.evt.DeleteUserEvt;
import com.xh.oauth.domain.user.evt.UpdateUserEvt;
import com.xh.oauth.inf.user.view.UserView;
import com.xh.oauth.inf.user.view.UserViewRepository;

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
		UserView userView = new UserView();
		BeanCopier beanCopier = BeanCopier.create(ChangePasswordEvt.class,UserView.class,false);
		beanCopier.copy(evt, userView, null);
		viewRepository.save(userView);
	}
	
	@EventHandler
	public void onUpdateUser(UpdateUserEvt evt){
		UserView userView = new UserView();
		BeanCopier beanCopier = BeanCopier.create(UpdateUserEvt.class,UserView.class,false);
		beanCopier.copy(evt, userView, null);
		viewRepository.save(userView);
	}
	
	@EventHandler
	public void onDeleteUser(DeleteUserEvt evt){
		viewRepository.delete(evt.getIdUser());
	}
}
