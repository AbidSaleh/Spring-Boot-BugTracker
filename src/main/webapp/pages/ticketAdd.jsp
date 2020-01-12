<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add Ticket</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"/>

	<div class="container">
	<h3>Add Ticket</h3>
    <strong>Fields with (*) is required</strong>

	<form:form action="addTicket" modelAttribute="ticketAttribute" method="POST">
    			<form:hidden path="ticketId" />
    			<table class="table table-striped">
    				<tbody>
    					<tr>
    						<td><label>Ticket title (*):</label></td>
    						<td><form:input path="title" /></td>
    						<form:errors path="title" cssClass="text-danger"/>
    					</tr>
                        <form:hidden path="creatorId"/>
                        <tr>
                            <td><label>Recipient (*):</label></td>
                            <td><select name="holderId">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.userId}">${user.firstName} ${user.lastName}</option>
                                    </c:forEach>
                                    <form:errors path="holderId" cssClass="text-danger"/>
                                </select>
                            </td>
                        </tr>
    				</tbody>
    			</table>
    			<button type="submit" class="btn btn-success">Save</button>

    		</form:form>

            <div>
            <a class="btn btn-secondary" href="<c:url value="/tickets/list" />">Back to Tickets List</a>
            </div>

    </div>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>