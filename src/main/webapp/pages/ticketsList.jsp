<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
   <title>Tickets list</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>




    <div class="container">
    <h3>Tickets List</h3>

    			<table class="table table-striped">
    				<tr>
    				    <th>Id</th>
    					<th>Created</th>
    					<th>Ticket title</th>
    					<th>Ticket creator</th>
    					<th>Ticket holder</th>
    					<th>Updated</th>
    					<th>Action</th>
    				</tr>

    				<c:forEach var="ticket" items="${tickets}">
    					<tr>
    					    <td> ${ticket.ticketId} </td>
    						<td> Date: ${ticket.createDate.toLocalDate()}<br>
    						Time: ${ticket.createDate.toLocalTime().withNano(0)} </td>
    						<td> ${ticket.title} </td>
    						<td> ${ticket.creator.firstName} ${ticket.creator.lastName} </td>
    						<td> ${ticket.holder.firstName} ${ticket.holder.lastName} </td>
    						<td> Date: ${ticket.updateDate.toLocalDate()}<br>
    						Time: ${ticket.updateDate.toLocalTime().withNano(0)}</td>
                            <td><button type="button" class="btn btn-primary"
                                 onclick="location.href='${ticket.ticketId}';">View Ticket</button>
                            </td>
    					</tr>

    				</c:forEach>

    			</table>

    			<div>
                    <button type="button" class="btn btn-success" onclick="location.href='add?userId=${param.userId}';">Add Ticket</button>
                </div>
                <br>
                <div>
                    <a class="btn btn-secondary" href="<c:url value="/tickets/list?userId=${ticket.creator.userId}" />">Back to Tickets List</a>
                </div>
    </div>

    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>