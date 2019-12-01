<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Users list</title>
</head>
<body>
<style>
   DIV.table
   {
       display:table; width: 100%;;
   }
   FORM.tr, DIV.tr
   {
       display:table-row;
       padding: 10px;
       margin: 10px;
   }
   SPAN.td
   {
       display:table-cell;
       padding: 10px;
       margin: 10px;
   }
   SPAN.th
   {
       display:table-cell;
       font-weight: bold;
   }
</style>
 <div class="table">
     <div class="tr">
         <span class="th">Id</span>
         <span class="th">Name</span>
         <span class="th">Creator Name</span>
         <span class="th">Holder Name</span>
     </div>
 <c:forEach items="${tickets}" var="ticket">
     <form:form class="tr" modelAttribute="userAttribute" action="" method="post">
         <span class="td"><c:out value="${ticket.id}"/></span>
         <span class="td"><c:out value="${ticket.name}"/></span>
         <span class="td"><c:out value="${ticket.holder.firstName}"/></span>
         <span class="td"><c:out value="${ticket.holder.lastName}"/></span>
     </form:form>
 </c:forEach>
 </div>
 <input type="button" onclick="location.href='add';" value="Add new user"/>
 <p>Go to <a href="<c:url value="/accounts/list" />">Accounts list</a></p>
</body>
</html>