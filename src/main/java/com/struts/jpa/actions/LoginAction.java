package com.struts.jpa.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.struts.jpa.annotations.ValidateWith;
import com.struts.jpa.model.User;
import com.struts.jpa.service.UserService;
import com.struts.jpa.validators.SignInValidator;
import com.struts.jpa.validators.Validator;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

    public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User> {

    @Autowired
    private UserService userService;
    public User user = new User();
    public String password2;
    Map<String, Object> session;

    @Override
    public void validate() {
        String actionName = ActionContext.getContext().getName();
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            addFieldError("userName", "Username is Required");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            addFieldError("password", "Password is Required");
        }
        if (actionName.equals("signup")) {
            if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
                addFieldError("firstName", "FirstName is Required");
            }
            if (getPassword2() == null || getPassword2().isEmpty()) {
                addFieldError("password2", "Confirm password is Required");
            }
            if (!user.getPassword().equals(getPassword2())) {
                addActionError("Passwords don't match");
            }
        }

    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @ValidateWith(SignInValidator.class)
    public String signin() {
        User u = userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (u != null) {
            this.session.put("firstName", u.getFirstName());
            this.session.put("user", u);
            return ActionSupport.SUCCESS;
        }
        addActionError("Wrong username or password");
        return ActionSupport.ERROR;
    }

    public String signup() {
        if (user.getPassword().equals(getPassword2())) {
            User u = userService.addUser(user);
            if (u != null) {
                return ActionSupport.SUCCESS;
            }
            addActionError("Wrong username or password");
            return ActionSupport.ERROR;
        }
        addActionError("Wrong username or password");
        return ActionSupport.ERROR;
    }

    @SkipValidation
    public String signout() {
        this.session.remove("firstName");
        this.session.remove("user");
        return ActionSupport.SUCCESS;
    }

    @Override
    public User getModel() {
        return user;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
