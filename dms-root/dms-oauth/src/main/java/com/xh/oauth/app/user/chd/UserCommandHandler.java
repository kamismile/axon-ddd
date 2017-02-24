package com.xh.oauth.app.user.chd;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xh.dms.base.exception.AppBizException;
import com.xh.oauth.domain.user.User;
import com.xh.oauth.inf.user.cmd.CreateUserCmd;
import com.xh.oauth.inf.user.view.UserView;
import com.xh.oauth.inf.user.view.UserViewRepository;

@Component
public class UserCommandHandler{
	
	@Autowired
	private UserViewRepository userViewRepository;
	
	@Autowired
	private Repository<User> repository;
	
	@CommandHandler
	public void createUser(CreateUserCmd cmd) throws AppBizException {
		UserView userView = userViewRepository.findByUserName(cmd.getUserName());
		if(userView != null){
			throw new AppBizException("", new UnsupportedOperationException(), "unsupported operation", cmd.getUserName());
		}
		repository.add(new User(cmd));
	}

}
