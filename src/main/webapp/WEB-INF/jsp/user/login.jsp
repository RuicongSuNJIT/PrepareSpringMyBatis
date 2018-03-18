<%--
  Created by IntelliJ IDEA.
  User: surc
  Date: 2018/3/18
  Time: 下午12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><spring:message code="login"/></title>
</head>
<body>
<div id="errorMsg">
    <c:if test="${error != null}">
        ${error.message}
    </c:if>
</div>
<form action="<c:url value="/authority/login"/>" method="post">
    <input type="text" name="username" placeholder="<spring:message code="username"/>"/> <br/>
    <input type="password" name="password" placeholder="<spring:message code="password"/>"><br/>
    <input type="submit" value="<spring:message code="login"/>"/>
</form>
<a href="<c:url value="/authority/register"/>"><spring:message code="register"/></a>
|
<a href="#"><spring:message code="forgot-password"/></a>
</body>
</html>
