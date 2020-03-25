package com.struts.jpa.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.jpa.model.User;
import com.struts.jpa.service.UserService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class RestAction extends ActionSupport implements SessionAware {
    Map<String, Object> session;

    @Autowired
    UserService userService;

    private List<User> users;

    public String getUser() {
        users = userService.getAllUsers();
        return "success";
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
