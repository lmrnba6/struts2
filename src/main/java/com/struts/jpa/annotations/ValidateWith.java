package com.struts.jpa.annotations;


import com.opensymphony.xwork2.validator.validators.ValidatorSupport;
import com.struts.jpa.validators.Validator;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Inherited
public @interface ValidateWith {
    Class<? extends Validator> value();
}