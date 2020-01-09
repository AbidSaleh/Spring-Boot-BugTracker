<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Edit Message Text</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
	    <h2>Edit Message</h2>
	    <strong>Fields with (*) is required</strong>

	    <form:form action="editMessage" modelAttribute="messageAttribute" method="POST">
	            <form:hidden path="messageId" value="${messageAttribute.messageId}"/>
    			<form:hidden path="ticketId" value="${param.ticketId}"/>
    			<form:hidden path="authorId" value="${param.authorId}"/>
    			<form:hidden path="recipientId" value="${param.recipientId}"/>

    			<table class="table table-striped">
    				<tbody>

    					<tr>
    						<td><label>Message text (*):</label></td>
    						<td><form:input path="text" /></td>
    						<form:errors path="text" cssClass="text-danger"/>
    					</tr>
    				</tbody>
    			</table>

    			<button type="submit" class="btn btn-success">Save</button>

    		</form:form>
            <div>
                <a class="btn btn-secondary" href="<c:url value="/tickets/list?userId=${param.authorId}" />">Back to Tickets List</a>
            </div>
    </div>

    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>