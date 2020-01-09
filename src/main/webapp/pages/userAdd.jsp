<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add user</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
   <link rel="stylesheet" type="text/css" href="/add-style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add user</h2>
			<i>Fields with (*) is required</i>
		</div>
	</div>
	<div id="container">
	<form:form action="addUser" modelAttribute="userAttribute" method="POST">
    			<form:hidden path="userId" />
    			<table>
    				<tbody>
    					<tr>
    						<td><label>First name (*):</label></td>
    						<td><form:input path="firstName" /></td>
    						<form:errors path="firstName" cssClass="error"/>
    					</tr>

    					<tr>
    						<td><label>Last name (*):</label></td>
    						<td><form:input path="lastName" /></td>
    						<form:errors path="lastName" cssClass="error"/>
    					</tr>

    					<tr>
    						<td><label>Email (*):</label></td>
    						<td><form:input path="email" /></td>
    						<form:errors path="email" cssClass="error"/>
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
    			<a href="<c:url value="/users/list" />">Back to Users List</a>
    		</p>

    	</div>
</body>
</html>