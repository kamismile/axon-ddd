package com.xh.dms.base.common.valid;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.validation.Valid;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;


/**
 * JSR303 Annotation Valid BeanPostProcess
 * 
 * @author xhtian
 * 
 */
public class JSR303ValidateAntationAdvisor extends StaticMethodMatcherPointcutAdvisor implements MethodInterceptor {

	private static Class<Valid> MATCHES_ANNOTATION_CLASS = JSR303MatcherAnnotationClass.CLAZZ;

	private transient MethodMatcher methodMatcher = new AnnotationParameterMatcher(MATCHES_ANNOTATION_CLASS);

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		ProxyMethodInvocation proxyMethodInvocation = (ProxyMethodInvocation) methodInvocation;
		Object proxy = proxyMethodInvocation.getProxy();
		Class<?> targetClass = AopUtils.getTargetClass(proxy);
		Method method = methodInvocation.getMethod();
		Method targetClassMethod = targetClass.getMethod(method.getName(), method.getParameterTypes());
		Object[] arguments = methodInvocation.getArguments();
		Annotation[][] parameterAnnotations = targetClassMethod.getParameterAnnotations();
		for (int i = 0; i < parameterAnnotations.length; i++) {
			Annotation[] annotations = parameterAnnotations[i];
			for (int j = 0; j < annotations.length; j++) {
				Annotation annotation = annotations[j];
				if (annotation.annotationType().equals(MATCHES_ANNOTATION_CLASS)) {
					Object argument = arguments[i];
					JSR303Validator.validate(argument);
				}
			}
		}
		return methodInvocation.proceed();
	}

	@Override
	public boolean matches(Method method, Class targetClass) {
		return methodMatcher.matches(method, targetClass);
	}

	@Override
	public Advice getAdvice() {
		return this;
	}

}
