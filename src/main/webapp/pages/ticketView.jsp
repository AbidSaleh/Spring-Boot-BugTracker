<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Ticket id ${ticket.getTicketId}</title>
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
<h3>Ticket id: {ticket.getTicketId}</h3>
<h3>Ticket name: {ticket.getName}</h3>
<h3>Ticket author: {ticket.getCreatorId}</h3>

 <div class="table">
            <div class="tr">
                <span class="th">Message Id</span>
                <span class="th">Author Id</span>
                <span class="th">Recipient Id</span>
                <span class="th">Text</span>
            </div>
        <c:forEach items="${ticket.getMessages()}" var="message">
            <form:form class="tr" modelAttribute="messageAttribute" action="" method="post">
                <span class="td"><c:out value="${message.messageId}"/></span>
                <span class="td"><c:out value="${message.authorId}"/></span>
                <span class="td"><c:out value="${message.recipientId}"/></span>
                <span class="td"><c:out value="${message.text}"/></span>
            </form:form>
        </c:forEach>
        </div>

         <div class="table">
                <c:forEach items="${ticket.getMessages()}" var="message">
                    <form:form class="tr" modelAttribute="messageAttribute" action="" method="post">
                    <span class="th">Message Id</span>
                        <span class="td"><c:out value="${message.messageId}"/></span>
                        <span class="th">Author Id</span>
                        <span class="td"><c:out value="${message.authorId}"/></span>
                        <span class="th">Recipient Id</span>
                        <span class="td"><c:out value="${message.recipientId}"/></span>
                        <span class="th">Text</span>
                        <span class="td"><c:out value="${message.text}"/></span>
                    </form:form>
                </c:forEach>
                </div>

</body>
</html>