<%--
  Created by IntelliJ IDEA.
  User: surc
  Date: 2018/3/17
  Time: 下午9:20
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html>
<title><spring:message code="learn-sm"/></title>
<body>
<c:choose>
    <c:when test="${user == null}">
        <form id="loginForm" action="<c:url value="/user/login"/>" method="post">
            <input type="text" name="username" placeholder="<spring:message code="username"/>"/>
            <input type="password" name="password" placeholder="<spring:message code="password"/>"/>
            <a href="#" onclick="login()"><spring:message code="login"/></a>
            <a href="<c:url value="/user/register"/>"><spring:message code="register"/></a>
        </form>
    </c:when>
    <c:otherwise>
        <spring:message code="welcome" arguments="${user.username}"/>
    </c:otherwise>
</c:choose>
</body>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.js"/>"></script>
<script type="text/javascript">
    function login() {
        $('#loginForm').submit();
    }
</script>
</html>
