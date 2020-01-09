<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add Ticket</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
   <link rel="stylesheet" type="text/css" href="/add-style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Ticket</h2>
			<i>Fields with (*) is required</i>
		</div>
	</div>
	<div id="container">
	<form:form action="addTicket" modelAttribute="ticketAttribute" method="POST">
    			<form:hidden path="ticketId" />
    			<table>
    				<tbody>
    					<tr>
    						<td><label>Ticket title (*):</label></td>
    						<td><form:input path="title" /></td>
    						<form:errors path="title" cssClass="error"/>
    					</tr>
                        <form:hidden path="creatorId"/>
                        <tr>
                            <td><label>Recipient (*):</label></td>
                            <td><select name="holderId">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.userId}">${user.firstName} ${user.lastName}</option>
                                    </c:forEach>
                                    <form:errors path="holderId" cssClass="error"/>
                                </select>
                            </td>
                        </tr>
    					<tr>
    						<td><label></label></td>
    						<td><input type="submit" value="Save" class="save" /></td>
    					</tr>

    				</tbody>
    			</table>

    		</form:form>

    		<div style="clear; both;"></div>

    		<p>
    			<a href="<c:url value="/tickets/list" />">Back to Tickets List</a>
    		</p>

    	</div>
</body>
</html>