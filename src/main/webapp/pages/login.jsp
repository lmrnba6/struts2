<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<form id="loginForm" class="Box" action="signin" method="POST">
    <s:actionerror class="error"/>
    <h1>Login</h1>
    <input name="userName" type="text" placeholder="<s:text name="global.userName" />">
    <s:fielderror fieldName="userName" class="error"/>
    <input name="password" type="password" placeholder="Password">
    <s:fielderror fieldName="userName" class="error"/>
    <button type="button" id="login">Login</button>
</form>
</body>
</html>