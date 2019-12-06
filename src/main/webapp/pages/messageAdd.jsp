<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add message</title>
</head>
<body>
<form:form modelAttribute="messageAttribute" action="addMessage" method="post">
   <table>
       <tr>
            <td>
                <form:hidden path="ticketId" value="${param.ticketId}"/>
            </td>
       </tr>
       <tr>
            <td>
                <form:hidden path="authorId" value="${param.authorId}"/>
            </td>
       </tr>
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
                   <td>
                       <form:label path="recipientId">recipientId</form:label>
                   </td>
                   <td>
                       <form:input path="recipientId"/>
                   </td>
               </tr>
            </c:otherwise>
        </c:choose>
       <tr>
           <td>
               <form:label path="text">text</form:label>
           </td>
           <td>
               <form:input path="text"/>
           </td>
       </tr>
   </table>

   <input type="submit" value="Save"/>
</form:form>
</body>
</html>