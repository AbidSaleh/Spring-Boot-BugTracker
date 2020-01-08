<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add ticket</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
<i cssClass = "info">Fields with (*) is required</i>
<br>
<br>
<form:form modelAttribute="ticketAttribute" action="addTicket" method="post">
   <table>
       <tr>
           <td>
               Ticket title(*) <form:input path="title" />
               <form:errors path="title" cssClass="error"/>
           </td>
       </tr>
       <tr>
            <td>
                <form:hidden path="creatorId"/>
            </td>
       </tr>
       <tr>
            <td>
                Recipient (*)<select name="holderId">
                    <c:forEach items="${users}" var="user">
                        <option value="${user.userId}">${user.firstName} ${user.lastName}</option>
                    </c:forEach>
                    <form:errors path="holderId" cssClass="error"/>
                </select>
            </td>
       </tr>
   </table>
   <input type="submit" value="Save"/>
</form:form>
</body>
</html>