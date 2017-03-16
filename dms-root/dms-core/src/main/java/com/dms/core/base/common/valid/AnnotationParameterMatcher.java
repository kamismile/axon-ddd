package com.dms.core.base.common.valid;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.util.Assert;

public class AnnotationParameterMatcher extends StaticMethodMatcher {
	
	private final Class<? extends Annotation> annotationType;


	/**
	 * Create a new AnnotationClassFilter for the given annotation type.
	 * @param annotationType the annotation type to look for
	 */
	public AnnotationParameterMatcher(Class<? extends Annotation> annotationType) {
		Assert.notNull(annotationType, "Annotation type must not be null");
		this.annotationType = annotationType;
	}


	public boolean matches(Method method, Class targetClass) {
		if(matchesParameter(method)){
			return true;
		}
		// The method may be on an interface, so let's check on the target class as well.
		Method specificMethod = AopUtils.getMostSpecificMethod(method, targetClass);
		return matchesParameter(specificMethod);
	}


	private boolean matchesParameter(Method method) {
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		for (Annotation[] annotations : parameterAnnotations) {
			for (Annotation annotation : annotations) {
				if(annotation.annotationType().equals(this.annotationType)){
					return true;
				}
			}
		}
		return false;
	}
}
