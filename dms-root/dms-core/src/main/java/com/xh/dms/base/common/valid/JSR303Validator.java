package com.xh.dms.base.common.valid;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xh.dms.base.exception.AppBizException;

/**
 * JSR303 验证器
 * 
 * @author xhtian
 *
 */
public class JSR303Validator {

	/**
	 * 返回一个Validator实例
	 * 
	 * @return
	 */
	private static Validator getValidator() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		return validatorFactory.getValidator();
	}

	/**
	 * 验证参数paramT，如果不正确抛出对应的异常
	 * 
	 * @param paramT
	 * @param paramArrayOfClass
	 * @throws AppBizException
	 */
	public static <T> void validate(T param, Class<?>... paramArrayOfClass) throws AppBizException {
		Validator validator = JSR303Validator.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(param, paramArrayOfClass);
		for (ConstraintViolation<T> constraintViolation : violations) {
			String violationCode = constraintViolation.getMessage();
			Object value = constraintViolation.getInvalidValue();
			throw new AppBizException(violationCode,
					"jsr303 validate error.The invalid property is:{0} and the invalid property value is:[{1}]",
					constraintViolation.getPropertyPath(), value);
		}
	}
}
