<%@ page import="com.struts.jpa.model.Tweet" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="ds" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<form class="Box">
    <s:a action="add">+ Add Tweet</s:a>
    <h1><s:text name="global.tweets"/></h1>
    <table>
        <th>Id</th>
        <th>Title</th>
        <th>Text</th>
        <th>Action</th>
        <s:iterator value="tweets" status="i">
            <tr>
                <td><s:a action="editTweet">
                    <s:param name="id" value="id"></s:param>
                    <s:property value="id"/>
                </s:a></td>
                <td><s:property value="title"/></td>
                <td><s:property value="text"/></td>
<%--                <td onclick="show()"><s:a action="deleteTweet">--%>
<%--                    <s:param name="id" value="id"></s:param>--%>
<%--                    Delete--%>
<%--                </s:a>--%>
                <td>
                <button type="button" onclick="deleteTweet(<s:property value="id"/>)">Delete</button>
                </td>
            </tr>
        </s:iterator>

    </table>
</form>
<div id="dialog">
    <h3>Are you sure?</h3>
    <div id="action">
        <button id="yes">Yes</button>
        <button id="cancel">Cancel</button>
    </div>
</div>
</body>
</html>