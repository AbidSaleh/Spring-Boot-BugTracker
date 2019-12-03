<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add message</title>
</head>
<body>
 <form:form modelAttribute="ticketAttribute" action="addMessage" method="post">
<form:form modelAttribute="messageAttribute" action="" method="post">
   <table>
   <tr>
         <td>
             <form:input path="${ticketAttribute.creatorId}" type="hidden"/>
         </td>
    </tr>
    <tr>
         <td>
             <form:input path="${ticketAttribute.recipientId}" type="hidden"/>
         </td>
    </tr>

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
</form:form>
</body>
</html>