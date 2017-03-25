<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.ByteArrayInputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.xml.bind.DatatypeConverter" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">

<div class="page-title">Product List</div>

<c:forEach items="${storages}" var="storage">
    <%
        String imgPath = "D:/1.jpg";
        BufferedImage bImage = ImageIO.read(new File(imgPath));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", baos);
        baos.flush();
        byte[] imageByte = baos.toByteArray();
        baos.close();
        String byte64 = DatatypeConverter.printBase64Binary(imageByte);
    %>
    <div class="product-preview-container">
        <ul>
            <li>

                <img class="product-image"
                     src="data:image/jpg;base64,<%= byte64%>" /></li>
            <li>Code: ${storage.id}</li>
            <li>Brand: ${storage.product.brand.brandName}</li>
            <li>Display: ${storage.product.display.displaySize}</li>
            <li>Processor: ${storage.product.processor.procName}</li>
            <li>RAM: ${storage.product.ram.ramSize}</li>
            <li>Amount: ${storage.amount}</li>
            <li>Price: <fmt:formatNumber value="${storage.price}" type="currency"/></li>

            <!-- For Customer edit Product -->
            <security:authorize  access="!hasAuthority('ADMIN')">
                <li><a
                        href="${pageContext.request.contextPath}/buyProduct?id=${storage.id}">
                    Buy Now</a></li>
            </security:authorize>

            <!-- For Admin edit Product -->
            <security:authorize  access="hasAuthority('ADMIN')">
                <li><a style="color:red;"
                       href="${pageContext.request.contextPath}/addproduct?id=${storage.id}">
                    Add Product</a></li>
                <li><a style="color:red;"
                       href="${pageContext.request.contextPath}/deleteproduct?id=${storage.id}">
                    Delete Product</a></li>
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
</body>
</html>



