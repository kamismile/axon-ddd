package com.xh.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.xh.oauth")
public class OAuthMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(OAuthMain.class);
		System.out.println("game started...");
	}
}
