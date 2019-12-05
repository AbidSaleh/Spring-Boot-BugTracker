<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add ticket</title>
</head>
<body>
<form:form modelAttribute="ticketAttribute" action="addTicket" method="post">
   <table>
       <tr>
           <td>
               <form:label path="name">Name</form:label>
           </td>
           <td>
               <form:input path="name"/>
           </td>
       </tr>
       <tr>
            <td>
                <form:hidden path="creatorId"/>
            </td>
       </tr>
       <tr>
            <td>
                <form:label path="holderId">Recipient</form:label>
            </td>
            <td>
                <form:input path="holderId"/>
            </td>
        </tr>
   </table>
   <input type="submit" value="Save"/>
</form:form>
</body>
</html>