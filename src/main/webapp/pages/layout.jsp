<%--
  Created by IntelliJ IDEA.
  User: louci
  Date: 2020-03-17
  Time: 6:41 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
    <link rel="stylesheet" type="text/css" href="../css/layout.css">
</head>
<body>
<div id="loader"></div>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<tiles:insertAttribute name="content"></tiles:insertAttribute>
<%--<tiles:insertAttribute name="footer"></tiles:insertAttribute>--%>
<script src="../js/jquery.min.js"></script>
<script SRC="../js/script.js"></script>
</body>
</html>
