package com.dms.core.base.common.utils.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;

/**
 * 注解工具类
 * 
 * @author xhtian
 * 
 */
public class AnnoUtils {

	public static Annotation findAnnotationOnMethod(Method m, Class targetClass, Class annotation) {
		Annotation a = AnnotationUtils.findAnnotation(m, annotation);
		if (a != null) {
			return a;
		}

		if (targetClass != null) {
			try {
				m = targetClass.getMethod(m.getName(), m.getParameterTypes());
				a = AnnotationUtils.findAnnotation(m, annotation);
				if (a != null) {
					return a;
				}
			} catch (NoSuchMethodException ignored) {
				// default return value is false. If we can't find the method,
				// then obviously
				// there is no annotation, so just use the default return value.
			}
		}
		return a;
	}

	public static boolean isAnnotationPresent(Method method, Class targetClass, Class annoClass) {
		Annotation annotation = AnnoUtils.findAnnotationOnMethod(method, targetClass, annoClass);
		if (null != annotation) {
			return true;
		}
		return false;
	}
}
