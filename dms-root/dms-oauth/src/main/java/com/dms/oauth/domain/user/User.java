package com.dms.oauth.domain.user;

import java.util.Date;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import com.dms.oauth.domain.user.evt.ChangePasswordEvt;
import com.dms.oauth.domain.user.evt.CreateUserEvt;
import com.dms.oauth.domain.user.evt.DeleteUserEvt;
import com.dms.oauth.domain.user.evt.UpdateUserEvt;
import com.dms.oauth.inf.user.cmd.ChangePasswordCmd;
import com.dms.oauth.inf.user.cmd.CreateUserCmd;
import com.dms.oauth.inf.user.cmd.DeleteUserCmd;
import com.dms.oauth.inf.user.cmd.UpdateUserCmd;

public class User extends AbstractAnnotatedAggregateRoot<String>{
	
	@AggregateIdentifier
	private String idUser;

	private String idClient;
	
	private String userName;
	
	private String realName;
	
	private String tel;
	
	private String status;
	
	private Date creationDate;
	
	private Date updateDate;
	
	private String pwd;
	
	private String salt;
	
	public User(){
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public User(CreateUserCmd cmd){
		CreateUserEvt evt = new CreateUserEvt(); 
		evt.setCreationDate(new Date());
		evt.setIdClient(cmd.getIdClient());
		evt.setIdUser(cmd.getIdUser());
		evt.setPwd(cmd.getPwd());
		evt.setRealName(cmd.getRealName());
		evt.setStatus(cmd.getStatus());
		evt.setTel(cmd.getTel());
		evt.setUpdateDate(new Date());
		evt.setUserName(cmd.getUserName());
		System.out.println("create 1.");
		apply(evt);
	}
	
	@EventSourcingHandler
	public void onCreate(CreateUserEvt evt){
		this.creationDate = evt.getCreationDate();
		this.idClient = evt.getIdClient();
		this.idUser = evt.getIdUser();
		this.pwd = evt.getPwd();
		this.realName = evt.getRealName();
		this.status = evt.getStatus();
		this.tel = evt.getTel();
		this.updateDate = evt.getUpdateDate();
		this.userName = evt.getUserName();
	}
	
	@CommandHandler
	public void changePwd(ChangePasswordCmd cmd){
		ChangePasswordEvt evt = new ChangePasswordEvt();
		evt.setNewPassword(cmd.getNewPassword());
		evt.setUserId(cmd.getUserId());
		apply(evt);
	}
	
	@EventSourcingHandler
	public void onPwdChanged(ChangePasswordEvt evt){
		this.pwd = evt.getNewPassword();
	}
	
	@CommandHandler
	public void updateUser(UpdateUserCmd cmd){
		UpdateUserEvt evt = new UpdateUserEvt();
		evt.setIdUser(cmd.getIdUser());
		evt.setRealName(cmd.getRealName());
		evt.setStatus(cmd.getStatus());
		evt.setTel(cmd.getTel());
		evt.setUpdateDate(new Date());
		apply(evt);
	}
	
	@EventSourcingHandler
	public void onUpdateUser(UpdateUserEvt evt){
		this.realName = evt.getRealName();
		this.status = evt.getStatus();
		this.tel = evt.getTel();
		this.updateDate = evt.getUpdateDate();
	}
	
	@CommandHandler
	public void deleteUser(DeleteUserCmd cmd){
		DeleteUserEvt evt = new DeleteUserEvt();
		evt.setIdUser(cmd.getIdUser());
		apply(evt);
	}
	
	@EventSourcingHandler
	public void onDeleteUser(DeleteUserEvt evt){
		markDeleted();
	}
}
