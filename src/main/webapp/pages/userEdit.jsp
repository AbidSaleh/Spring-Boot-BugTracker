<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add user</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"/>
	<div class="container">

	    <h2>Edit user</h2>
	    <strong>Fields with (*) is required</strong>

	    <form:form action="editUser" modelAttribute="userAttribute" method="POST">
    			<form:hidden path="userId" />
    			<table class="table table-striped">
    				<tbody>
    					<tr>
    						<td><label>First name (*):</label></td>
    						<td><form:input path="firstName" /></td>
    						<td><form:errors path="firstName" cssClass="text-danger"/></td>
    					</tr>

    					<tr>
    						<td><label>Last name (*):</label></td>
    						<td><form:input path="lastName" /></td>
    						<td><form:errors path="lastName" cssClass="text-danger"/></td>
    					</tr>

    					<tr>
    						<td><label>Email (*):</label></td>
    						<td><form:input path="email" /></td>
    						<td><form:errors path="email" cssClass="text-danger"/></td>
    					</tr>

                        <tr>
                            <td><label>Role (*):</label></td>
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
            <a class="btn btn-secondary" href="<c:url value="/users/list" />">Back to Users List</a>
            </div>

    </div>
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>