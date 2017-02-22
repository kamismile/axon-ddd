package com.xh.dms.base.common.env;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.commons.lang3.StringUtils;

public class EnvResolver {

	private static final String ENV_CONFIG_ARG = "envConfigArg";

	public void resolveEnv(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		String parameter = getInitParameter(servletContext);
		String env = getEnv(parameter);
		if (StringUtils.isBlank(env)) {
			System.setProperty(parameter, StringUtils.EMPTY);
		}
		servletContext.log("current env is:[" + env + "]");
	}

	public String getEnv(ServletContext servletContext) {
		String parameter = getInitParameter(servletContext);
		return getEnv(parameter);
	}

	private String getEnv(String parameter) {
		return System.getProperty(parameter);
	}

	public void clearEnv(ServletContextEvent event) {
		String parameter = getInitParameter(event.getServletContext());
		System.clearProperty(parameter);
	}

	private String getInitParameter(ServletContext servletContext) {
		return servletContext.getInitParameter(ENV_CONFIG_ARG);
	}

}
