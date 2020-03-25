package com.struts.jpa.validators;

import com.opensymphony.xwork2.ActionSupport;

public interface Validator<T extends ActionSupport> {
    void validate(T action);
    default void addInvalidStateError(ActionSupport action) {
        action.addActionError(action.getText("Error"));
    }
}
