<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 17.10.2015
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <style>
        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<body>
<div id="login-box">
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h2>
		Welcome : ${pageContext.request.userPrincipal.name}
	</h2>
</c:if>

<c:url var="logoutUrl" value='/logout'/>
<form action="${logoutUrl}" method="post">
	<input type="submit" value="Log out" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</div>
</body>
</html>