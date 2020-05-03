package com.codenation.aceleradev.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface NotEnum {

    Class<? extends Enum<?>> enumClass();

    String message() default "Invalid value!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}