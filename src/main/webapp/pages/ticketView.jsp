<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
   <title>Ticket id <c:out value="${ticket.ticketId}"/></title>
   <link rel="stylesheet" type="text/css" href="/view-style.css"/>
</head>

<body>
    <div id="wrapper">
		<div id="header">
            <table>
            	<tr>
            	    <th>Id</th>
            		<th>Created</th>
            		<th>Ticket title</th>
            		<th>Ticket creator</th>
            		<th>Ticket holder</th>
            		<th>Updated</th>
            	</tr>
                <tr>
                    <td> ${ticket.ticketId} </td>
                    <td> ${ticket.createDate} </td>
                    <td> ${ticket.title} </td>
                    <td> ${ticket.creator.firstName} ${ticket.creator.lastName} </td>
                    <td> ${ticket.holder.firstName} ${ticket.holder.lastName} </td>
                    <td> ${ticket.updateDate} </td>
    			</tr>
            </table>
		</div>
	</div>

    <div id="container">

    		<div id="content">

    			<input type="button" value="Add Message"
    				   onclick="location.href='addMessageForm?ticketId=${ticket.ticketId}&authorId=${ticket.creator.userId}';"
    				   class="add-button"
    			/>

    			<table>
    				<tr>
    				    <th>Id</th>
    					<th>Created</th>
    					<th>Message author</th>
    					<th>Message recipient</th>
    					<th>Text</th>
    					<th>Updated</th>
    					<th>Action</th>
    				</tr>

    				<c:forEach var="message" items="${ticket.getMessages()}">
    					<tr>
    					    <td> ${message.messageId} </td>
    						<td> ${message.createDate} </td>
    						<td> ${message.author.firstName} ${message.author.lastName} </td>
    						<td> ${message.recipient.firstName} ${message.recipient.lastName} </td>
    						<td> ${message.text} </td>
    						<td> ${message.updateDate} </td>
                            <td><input type="button" onclick="location.href='/tickets/editMessageForm?ticketId=${message.ticket.ticketId}&messageId=${message.messageId}'" value="Edit message" class="get-button"/></td>

    					</tr>

    				</c:forEach>

    			</table>

    		</div>

    		<p>
    			<a href="<c:url value="/users/tickets" />">Back to Tickets List</a>
    		</p>
    	</div>

</body>
</html>