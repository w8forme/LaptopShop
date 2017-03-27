<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header-container">

    <div class="site-name">Online Shop</div>

    <div class="header-bar">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            Hello
            <a href="<c:url value="/accountinfo?name=${pageContext.request.userPrincipal.name}" />">
                    ${pageContext.request.userPrincipal.name} </a>
            &nbsp;|&nbsp;
            <a href="<c:url value="/logout" />">Logout</a>

        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="<c:url value="/login" />">Login</a>
        </c:if>
    </div>
</div>