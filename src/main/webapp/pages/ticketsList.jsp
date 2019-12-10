<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Tickets list</title>
</head>
<body>
<style>
   DIV.table
   {
       display:table; width: 70%;;
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
         <span class="th">Ticket Id</span>
         <span class="th">Ticket name</span>
         <span class="th">Ticket creator Id</span>
         <span class="th">Ticket holder Id</span>
     </div>
 <c:forEach items="${tickets}" var="ticket">
     <form:form class="tr" modelAttribute="ticketAttribute" action="" method="post">
         <span class="td"><c:out value="${ticket.ticketId}"/></span>
         <span class="td"><c:out value="${ticket.name}"/></span>
         <span class="td"><c:out value="${ticket.creatorId}"/></span>
         <span class="td"><c:out value="${ticket.holderId}"/></span>
     </form:form>
 </c:forEach>
 </div>
 <input type="button" onclick="location.href='add?userId=${param.userId}';" value="Add new ticket"/>
</body>
</html>