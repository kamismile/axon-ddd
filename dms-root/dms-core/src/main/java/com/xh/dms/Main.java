package com.xh.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(scanBasePackages = "com.xh.dms")
public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Main.class);
//		IUserService userService = (IUserService)applicationContext.getBean("commandGateWay");
		
//		String userId = UUID.randomUUID().toString();
//		System.out.println("new user id:["+userId+"]");
//		CreateUserCmd createUserCmd = new CreateUserCmd(userId,"kook",10,"kookpwd");
//		userService.createUser(createUserCmd);
		
//		String userId = UUID.randomUUID().toString();
//		System.out.println("---------------------------------");
//		System.out.println("new user id:["+userId+"]");
//		CreateUserCmd createUserCmd = new CreateUserCmd(userId,"kook",10,"kookpwd");
//		userService.createUser(createUserCmd);
		
//		String userId = "cdcf2842-86d1-49bf-851e-d218adc180b7";
//		for (int i = 0; i < 20; i++) {
//			System.out.println("loooooooooooooooooooooooooooooooooooooooop["+i+"]");
//			UpdateUserPwdCmd updateUserPwdCmd = new UpdateUserPwdCmd(userId,"hello_kook_" + i);
//			userService.updateUserPwd(updateUserPwdCmd);
//		}
		
//		String userId = "cdcf2842-86d1-49bf-851e-d218adc180b7";
//		UpdateUserPwdCmd updateUserPwdCmd = new UpdateUserPwdCmd(userId,"hello_kook_300");
//		userService.updateUserPwd(updateUserPwdCmd);
		System.out.println("game over");
	}
}
