package com.xh.dms.base.common.valid;

import java.lang.reflect.Method;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


public class JSR303ValidateAntationBeanPostProcessor implements BeanPostProcessor{

	private JSR303ValidateAntationAdvisor advisor = new JSR303ValidateAntationAdvisor();

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		MethodMatcher methodMatcher = advisor.getMethodMatcher();
		Class<? extends Object> clazz = bean.getClass();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if(methodMatcher.matches(method, clazz)){
				ProxyFactory factory = new ProxyFactory(bean);
				factory.addAdvice(advisor.getAdvice());
				return factory.getProxy();
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
