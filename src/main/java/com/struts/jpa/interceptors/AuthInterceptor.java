package com.struts.jpa.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation inv) throws Exception {
        ActionContext context = inv.getInvocationContext();
        SessionMap<String,Object> map = (SessionMap<String,Object>) inv.getInvocationContext().getSession();
        //for login and register actions ignore checking
        if(context.getName().equalsIgnoreCase("login") || context.getName().equalsIgnoreCase("register"))
        {
            if(map.get("firstName") != null){
                return "index";
            }
            return inv.invoke();
        }
        if(map==null)
        {
            return "login";
        }
        Object user = map.get("firstName");
        if(user==null ||user.equals("") || map.isEmpty() || map == null ){
            return "login";
        }

        return inv.invoke();
    }
}
