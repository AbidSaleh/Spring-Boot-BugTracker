<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
   <title>Users list</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>

<body>
    <div id="wrapper">
		<div id="header">
			<h2>Users List</h2>
		</div>
	</div>

    <div id="container">

    		<div id="content">

    			<input type="button" value="Add User"
    				   onclick="location.href='add';"
    				   class="add-button"
    			/>

    			<table>
    				<tr>
    				    <th>Id</th>
    					<th>First Name</th>
    					<th>Last Name</th>
    					<th>Email</th>
    					<th>Action</th>
    				</tr>

    				<c:forEach var="user" items="${users}">
    					<tr>
    					    <td> ${user.userId} </td>
    						<td> ${user.firstName} </td>
    						<td> ${user.lastName} </td>
    						<td> ${user.email} </td>
                            <td><input type="button" onclick="location.href='/tickets/list?userId=${user.userId}'" value="Get tickets" class="get-button"/></td>

    					</tr>

    				</c:forEach>

    			</table>

    		</div>

    	</div>

</body>
</html>