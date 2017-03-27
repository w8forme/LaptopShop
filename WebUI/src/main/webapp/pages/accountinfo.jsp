<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Account Info</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/css/styles.css">

</head>
<body>


<jsp:include page="_header.jsp"/>

<div class="page-title">Account Info</div>

<div class="account-container" modelAttribute="customer" >
    <ul>
        <li>User Name: ${pageContext.request.userPrincipal.name}</li>
        <li>Role: ${customer.role.userRole}</li>
    </ul>
</div>


<jsp:include page="_footer.jsp"/>

</body>
</html>