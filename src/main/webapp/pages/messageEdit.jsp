<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Edit Message Text</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
   <link rel="stylesheet" type="text/css" href="/add-style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Edit Message Text</h2>
			<i>Fields with (*) is required</i>
		</div>
	</div>
	<div id="container">
	<form:form action="editMessage" modelAttribute="messageAttribute" method="POST">
	            <form:hidden path="messageId" value="${messageAttribute.messageId}"/>
    			<form:hidden path="ticketId" value="${param.ticketId}"/>
    			<form:hidden path="authorId" value="${param.authorId}"/>
    			<form:hidden path="recipientId" value="${param.recipientId}"/>
    			<table>
    				<tbody>

    					<tr>
    						<td><label>Message text (*):</label></td>
    						<td><form:input path="text" /></td>
    						<form:errors path="text" cssClass="error"/>
    					</tr>
    					<tr>
    						<td><label></label></td>
    						<td><input type="submit" value="Save" class="add-button" /></td>
    					</tr>

    				</tbody>
    			</table>

    		</form:form>
    	</div>
</body>
</html>