<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Add user</title>
   <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
<h3>Add user</h3>
<i cssClass = "info">Fields with (*) is required</i>
<br>
<br>
<form:form modelAttribute="userAttribute" action="addUser" method="post">
   <table>
       <tr>
           <td>
               User First Name(*) <form:input path="firstName" />
               <form:errors path="firstName" cssClass="error"/>
           </td>
       </tr>
       <tr>
           <td>
            User Last Name(*) <form:input path="lastName" />
            <form:errors path="lastName" cssClass="error"/>
           </td>
       </tr>
       <tr>
           <td>
            Email(*) <form:input path="email" />
            <form:errors path="email" cssClass="error"/>
           </td>
       </tr>
   </table>
   <input type="submit" value="Save"/>
</form:form>
</body>
</html>