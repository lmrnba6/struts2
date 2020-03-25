package com.struts.jpa.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.Locale;
import java.util.Map;

public class LocalAction extends ActionSupport implements Preparable, SessionAware {
    public String backurl;
    public String lang;
    Map<String, Object> session;


    public String language() {
        ActionContext.getContext().setLocale(new Locale(lang));
        session.put("lang", lang);
        return ActionSupport.SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        backurl = request.getHeader("referer");
        URL url = new URL(backurl);
        backurl = url.getFile().replace("/", "");
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
