package com.xh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(scanBasePackages = "com.xh")
public class WebMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebMain.class);
		System.out.println("WebMain started...");
	}
}
