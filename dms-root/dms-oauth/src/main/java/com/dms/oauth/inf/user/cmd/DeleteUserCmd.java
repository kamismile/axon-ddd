package com.dms.oauth.inf.user.cmd;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import io.swagger.annotations.ApiModel;

@ApiModel
public class DeleteUserCmd {

	@TargetAggregateIdentifier
	private String idUser;

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	
}
