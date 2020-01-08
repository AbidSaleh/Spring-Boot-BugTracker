<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add message</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
<i cssClass = "info">Fields with (*) is required</i>
<br>
<br>
<form:form modelAttribute="messageAttribute" action="editMessage" method="post">
   <table>
       <tr>
            <td>
                <form:hidden path="messageId" value="${messageAttribute.messageId}"/>
            </td>
       </tr>
       <tr>
            <td>
                <form:hidden path="ticketId" value="${messageAttribute.ticketId}"/>
            </td>
       </tr>
       <tr>
            <td>
                <form:hidden path="authorId" value="${messageAttribute.authorId}"/>
            </td>
       </tr>
               <tr>
                    <td>
                        <form:hidden path="recipientId" value="${param.recipientId}"/>
                    </td>
               </tr>
       <tr>
           <td>
               Message text(*) <form:input path="text" />
               <form:errors path="text" cssClass="error"/>
           </td>
       </tr>
   </table>

   <input type="submit" value="Save"/>
</form:form>
</body>
</html>