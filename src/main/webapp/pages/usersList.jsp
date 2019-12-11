<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Users list</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
<h1>Users list</h1>
 <div class="table">
     <div class="tr">
         <span class="th">Id</span>
         <span class="th">First Name</span>
         <span class="th">Last Name</span>
         <span class="th">Email</span>
     </div>
 <c:forEach items="${users}" var="user">
     <form:form class="tr" modelAttribute="userAttribute" action="" method="post">
         <span class="td"><c:out value="${user.userId}"/></span>
         <span class="td"><c:out value="${user.firstName}"/></span>
         <span class="td"><c:out value="${user.lastName}"/></span>
         <span class="td"><c:out value="${user.email}"/></span>
         <span class="td">
            <input type="button" onclick="location.href='/tickets/list?userId=${user.userId}'" value="Get tickets"/>
         </span>
     </form:form>
 </c:forEach>
 </div>
 <input type="button" onclick="location.href='add';" value="Add new user"/>
</body>
</html>