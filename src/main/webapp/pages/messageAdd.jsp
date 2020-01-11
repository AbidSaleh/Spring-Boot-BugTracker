<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add Message</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	    <h2>Add Message</h2>
	    <strong>Fields with (*) is required</strong>
	    <form:form action="addMessage" modelAttribute="messageAttribute" method="POST">
    			<form:hidden path="ticketId" value="${param.ticketId}"/>
    			<form:hidden path="authorId" value="${param.authorId}"/>
                <form:hidden path="createDate" />
    			<table class="table">
    				<tbody>

                    <c:choose>
                        <c:when test="${param.recipientId>0}">
                           <tr>
                                <td>
                                    <form:hidden path="recipientId" value="${param.recipientId}"/>
                                </td>
                           </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                     <td><label>Recipient (*):</label></td>
                                     <td><select name="recipientId">
                                         <c:forEach items="${users}" var="user">
                                             <option value="${user.userId}">${user.firstName}  ${user.lastName}</option>
                                         </c:forEach>
                                         <form:errors path="recipientId" cssClass="text-danger"/>
                                     </select>
                                    </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>

    					<tr>
    						<td><label>Message text (*):</label></td>
    						<td><form:input path="text" /></td>
    						<form:errors path="text" cssClass="error"/>
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