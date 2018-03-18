<%--
  Created by IntelliJ IDEA.
  User: surc
  Date: 2018/3/17
  Time: 下午10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="register"/></title>
</head>
<body>
<div id="errorMsg"></div>
<form onsubmit="return false;">
    <input type="text" id="username" placeholder="<spring:message code="username"/>"/> <br/>
    <input type="password" id="password" placeholder="<spring:message code="password"/>"><br/>
    <input type="submit" onclick="register()" value="<spring:message code="register"/>"/>
</form>
</body>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.js"/>"></script>
<script type="text/javascript">
    var $errorMsg = $('#errorMsg');

    function register() {
        $.ajax({
            'url': '<c:url value="/user/register"/>',
            'type': 'post',
            'data': {
                'username': $('#username').val(),
                'password': $('#password').val()
            },
            'dataType': 'json',
            'success': function (data) {
                if (data.status === 'ok') {
                    window.location = '<c:url value="/"/>';
                } else {
                    $errorMsg.html(data.msg);
                }
            }
        });
    }
</script>
</html>
