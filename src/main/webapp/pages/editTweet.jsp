<%@ page import="com.struts.jpa.model.Tweet" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="ds" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>

<form class="Box" action="updateTweet" method="POST">
    <s:actionerror class="error"/>
    <h1>Edit Tweet <s:property value="%{tweet.id}"/> </h1>
    <input id="id" hidden name="id" value="<s:property value="%{tweet.id}"/>" >
    <input id="title" name="title" value="<s:property value="%{tweet.title}"/>" type="text" placeholder="Title">
    <s:fielderror fieldName="title" class="error"/>
    <input id="text" name="text" type="text" value="<s:property value="%{tweet.text}"/>" placeholder="Text">
    <s:fielderror fieldName="text" class="error"/>
    <input class="btn" onclick="show()" type="submit" value="Save">
</form>
</body>
</html>