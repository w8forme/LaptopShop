<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://rawgithub.com/hayageek/jquery-upload-file/master/css/uploadfile.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="https://rawgithub.com/hayageek/jquery-upload-file/master/js/jquery.uploadfile.min.js"></script>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product List</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/css/styles.css">


</head>
<body>

<jsp:include page="_header.jsp" />

<fmt:setLocale value="en_US" scope="session"/>

<sec:authorize access="!isAuthenticated()">
    <jsp:forward page="/login"></jsp:forward>
</sec:authorize>
<sec:authorize access="isAuthenticated()">

<div class="page-title">Product List</div>

<c:forEach items="${storages}" var="storage">

    <div class="product-preview-container">
        <ul>
            <li>
                <img class="product-image" onerror="this.src='pages/images/${storage.photo}'"
                     src=${pageContext.request.contextPath}pages/tmpFiles/${storage.photo}></li>
            <li>Code: ${storage.id}</li>
            <li>Brand: ${storage.product.brand.brandName}</li>
            <li>Display: ${storage.product.display.displaySize}</li>
            <li>Processor: ${storage.product.processor.procName}</li>
            <li>RAM: ${storage.product.ram.ramSize}</li>
            <li>Amount: ${storage.amount}</li>
            <li>Price: <fmt:formatNumber value="${storage.price}" type="currency"/></li>

            <!-- For Customer edit Product -->
            <security:authorize  access="!hasAuthority('ADMIN')">
                <li>
                    <form method="POST" action="${pageContext.request.contextPath}/buyProduct?id=${storage.id}">
                        <input type="submit" value="Buy Now"<c:if test="${storage.amount == 0}"><c:out value="disabled='disabled'"/></c:if>>
                    </form>
               </li>
            </security:authorize>

            <!-- For Admin edit Product -->
            <security:authorize  access="hasAuthority('ADMIN')">
                <li>
                    <form method="POST" action="${pageContext.request.contextPath}/addproduct?id=${storage.id}">
                        <input type="submit" value="Add Laptop">
                    </form>
                </li>
                <li>
                    <form method="POST" action="${pageContext.request.contextPath}/deleteproduct?id=${storage.id}">
                        <input type="submit" value="Delete Laptop"<c:if test="${storage.amount == 0}"><c:out value="disabled='disabled'"/></c:if>>
                    </form>
                </li>
                <li>
                    <form method="POST" action="uploadFile?id=${storage.id}" enctype="multipart/form-data">
                    File to upload: <input type="file" name="file">
                    <input type="submit" value="Upload">
                </form>
                </li>
            </security:authorize>

        </ul>
    </div>
</c:forEach>
<br/>
</sec:authorize>
<jsp:include page="_footer.jsp"/>
</body>
</html>



