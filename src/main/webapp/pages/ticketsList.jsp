<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
   <title>Tickets list</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>

<body>
    <div id="wrapper">
		<div id="header">
			<h2>Tickets List</h2>
		</div>
	</div>

    <div id="container">

    		<div id="content">

    			<input type="button" value="Add Ticket"
    				   onclick="location.href='add?userId=${param.userId}';"
    				   class="add-button"
    			/>

    			<table>
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
    						<td> ${ticket.createDate} </td>
    						<td> ${ticket.title} </td>
    						<td> ${ticket.creator.firstName} ${ticket.creator.lastName} </td>
    						<td> ${ticket.holder.firstName} ${ticket.holder.lastName} </td>
    						<td> ${ticket.updateDate} </td>
                            <td><input type="button" onclick="location.href='${ticket.ticketId}';" value="View ticket" class="get-button"/></td>

    					</tr>

    				</c:forEach>

    			</table>

    		</div>

    		<p>
    			<a href="<c:url value="/users/list" />">Back to Users List</a>
    		</p>
    	</div>

</body>
</html>