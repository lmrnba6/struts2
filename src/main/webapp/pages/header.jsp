<%--
  Created by IntelliJ IDEA.
  User: louci
  Date: 2020-03-17
  Time: 6:42 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    Object name = session.getAttribute("firstName");
    if (name == null) {
        name = "";
    }
%>
<div>
    <header><h1><%=name%>
    </h1></header>
    <nav>
        <div>
            <s:if test="%{#session.firstName != null}">
                <s:a action="index" id="logo"><s:text name="global.home"/> </s:a>
                <s:a action="tweet" id="logo"><s:text name="global.tweets"/></s:a>
            </s:if>
            <s:if test="%{#session.firstName == null}">
                <s:a action="login" id="logo"><s:text name="global.login"/></s:a>
                <s:a action="register" id="logo"><s:text name="global.register"/></s:a>
            </s:if>
            <s:else>
                <s:a action="signout" id="logo"><s:text name="global.logout"/></s:a>
            </s:else>
                <s:select  value="#request.locale" name="langs"  list="{'en' ,'fr'}" id="langSelect"/>
            <s:a action="admin" id="logo">ReactJscvbcvb.</s:a>


        <%--            <s:a action="language?lang=en">English</s:a>--%>
<%--            <s:a action="language?lang=fr">Francais</s:a>--%>
<%--            <s:a><s:property value="#loader"></s:property></s:a>--%>
        </div>
    </nav>
</div>
