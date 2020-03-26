<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<form class="Box" action="signup" method="POST">
    <s:actionerror class="error"/>
    <h1>Register</h1>
    <input name="userName" type="text" placeholder="Username">
    <s:fielderror fieldName="userName" class="error"/>
    <input name="firstName" type="text" placeholder="Name">
    <s:fielderror fieldName="firstName" class="error"/>
    <input name="password" type="password" placeholder="Password">
    <s:fielderror fieldName="password" class="error"/>
    <input name="password2" type="password" placeholder="Confirm">
    <s:fielderror fieldName="password2" class="error"/>
    <input type="submit" value="Register">
</form>
</body>
</html>