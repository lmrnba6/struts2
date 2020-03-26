<%@ page import="com.struts.jpa.model.Tweet" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="ds" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>

<form class="Box" action="addTweet" method="POST">
    <s:actionerror class="error"/>
    <h1>Add Tweet</h1>
    <input id="title" name="title" type="text" placeholder="Title">
    <s:fielderror fieldName="title" class="error"/>
    <input id="text" name="text" type="text" placeholder="Text">
    <s:fielderror fieldName="text" class="error"/>
    <input onclick="show()" type="submit" class="btn" value="Add">
</form>
</body>
</html>