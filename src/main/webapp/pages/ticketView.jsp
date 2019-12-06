<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Ticket id <c:out value="${ticket.ticketId}"/></title>
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
<h3>Ticket id: <c:out value="${ticket.ticketId}"/></h3>
<h3>Ticket name: <c:out value="${ticket.name}"/></h3>
<h3>Ticket author: <c:out value="${ticket.creatorId}"/></h3>

 <div class="table">
            <div class="tr">
                <span class="th">Message Id</span>
                <span class="th">Author Id</span>
                <span class="th">Recipient Id</span>
                <span class="th">Text</span>
            </div>
        <c:forEach items="${ticket.getMessages()}" var="message">
            <form:form class="tr" modelAttribute="messageAttribute" action="" method="post">
                <span class="td"><c:out value="${message.value.messageId}"/></span>
                <span class="td"><c:out value="${message.value.authorId}"/></span>
                <span class="td"><c:out value="${message.value.recipientId}"/></span>
                <span class="td"><c:out value="${message.value.text}"/></span>
                <span class="td">
                    <input type="button" onclick="location.href='/tickets/addMessageForm?ticketId=${ticket.ticketId}&authorId=${ticket.creatorId}&recipientId=-1'"
                    value="Add message"/>
                </span>
            </form:form>
        </c:forEach>
        </div>

</body>
</html>