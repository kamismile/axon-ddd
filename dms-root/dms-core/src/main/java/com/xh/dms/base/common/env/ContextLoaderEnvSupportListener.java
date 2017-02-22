package com.xh.dms.base.common.env;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class ContextLoaderEnvSupportListener extends ContextLoaderListener{
	
	private EnvResolver evnResolver = new EnvResolver();  

	@Override
	public void contextInitialized(ServletContextEvent event) {
		evnResolver.resolveEnv(event);
		super.contextInitialized(event);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		evnResolver.clearEnv(event);
		super.contextDestroyed(event);
	}
}
