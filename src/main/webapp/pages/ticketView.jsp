<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Ticket id <c:out value="${ticket.ticketId}"/></title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
<h3>Ticket id: <c:out value="${ticket.ticketId}"/></h3>
<h3>Ticket name: <c:out value="${ticket.title}"/></h3>
<h3>Ticket author: <c:out value="${ticket.creator.firstName} ${ticket.creator.lastName}"/></h3>

 <div class="table">
            <div class="tr">
                <span class="th">Message Id</span>
                <span class="th">Created</span>
                <span class="th">Author</span>
                <span class="th">Recipient</span>
                <span class="th">Text</span>
                <span class="th">Updated</span>
            </div>

        <c:forEach items="${ticket.getMessages()}" var="message">
            <form:form class="tr" modelAttribute="messageAttribute" action="" method="post">
                <span class="td"><c:out value="${message.messageId}"/></span>
                <span class="td"><c:out value="${message.createDate}"/></span>
                <span class="td"><c:out value="${message.author.firstName} ${message.author.lastName}"/></span>
                <span class="td"><c:out value="${message.recipient.firstName} ${message.recipient.lastName}"/></span>
                <span class="td"><c:out value="${message.text}"/></span>
                <span class="td"><c:out value="${message.updateDate}"/></span>
                <span class="td">
                    <input type="button" onclick="location.href='/tickets/editMessageForm?ticketId=${message.ticket.ticketId}&messageId=${message.messageId}'"
                    value="Edit message"/>
                </span>
            </form:form>
        </c:forEach>
        </div>
        <input type="button" onclick="location.href='addMessageForm?ticketId=${ticket.ticketId}&authorId=${ticket.creator.userId}';" value="Add new message"/>
  <div>Go to <a href="<c:url value="/tickets/list" />">Tickets list</a>
</body>
</html>