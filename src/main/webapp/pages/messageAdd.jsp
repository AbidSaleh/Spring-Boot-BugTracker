<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add Message</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
   <link rel="stylesheet" type="text/css" href="/add-style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Message</h2>
			<i>Fields with (*) is required</i>
		</div>
	</div>
	<div id="container">
	<form:form action="addMessage" modelAttribute="messageAttribute" method="POST">
    			<form:hidden path="ticketId" value="${param.ticketId}"/>
    			<form:hidden path="authorId" value="${param.authorId}"/>
    			<table>
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
                                         <form:errors path="holderId" cssClass="error"/>
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
    					<tr>
    						<td><label></label></td>
    						<td><input type="submit" value="Save" class="save" /></td>
    					</tr>

    				</tbody>
    			</table>

    		</form:form>
    	</div>
</body>
</html>