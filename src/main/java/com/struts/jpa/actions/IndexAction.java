package com.struts.jpa.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class IndexAction extends ActionSupport implements SessionAware, Preparable {

    Map<String, Object> session;

    public String index() {
        return ActionSupport.SUCCESS;
    }

    public String login() {
        return ActionSupport.SUCCESS;
    }

    public String register() {
        return ActionSupport.SUCCESS;
    }

    public String admin() {
        return ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = session;
    }

    @Override
    public void prepare() throws Exception {
    }
}
