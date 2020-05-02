package com.codenation.aceleradev.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LevelValidator implements ConstraintValidator<NotLevel, Level> {
    private Level[] values;

    @Override
    public void initialize(NotLevel constraint) {
        this.values = constraint.anyOf();
    }

    @Override
    public boolean isValid(Level value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(values).contains(value);
    }

}
