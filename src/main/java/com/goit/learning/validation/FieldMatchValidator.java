package com.goit.learning.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

import static org.springframework.util.ReflectionUtils.findField;
import static org.springframework.util.ReflectionUtils.getField;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String message;

    public void initialize(FieldMatch constraint) {
        firstFieldName = constraint.first();
        secondFieldName = constraint.second();
        message = constraint.message();
    }

    public boolean isValid(final Object obj, ConstraintValidatorContext context) {
        Object firstObj = getFieldValue(firstFieldName, obj);
        Object secondObj = getFieldValue(secondFieldName, obj);
        boolean valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        if (!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }

    private Object getFieldValue(String fieldName, Object obj) {
        Field field = findField(obj.getClass(), fieldName);
        field.setAccessible(true);
        Object value = getField(field, obj);
        field.setAccessible(false);
        return value;
    }
}
