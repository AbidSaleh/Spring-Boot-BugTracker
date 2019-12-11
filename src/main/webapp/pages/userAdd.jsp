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
<form:form modelAttribute="userAttribute" action="addUser" method="post">
   <table>
       <tr>
           <td>
               <form:label path="firstName">User First Name</form:label>
           </td>
           <td>
               <form:input path="firstName"/>
           </td>
       </tr>
       <tr>
           <td>
               <form:label path="lastName">User Last Name</form:label>
           </td>
           <td>
               <form:input path="lastName"/>
           </td>
       </tr>
       <tr>
                  <td>
                      <form:label path="email">User email</form:label>
                  </td>
                  <td>
                      <form:input path="email"/>
                  </td>
              </tr>
   </table>
   <input type="submit" value="Save"/>
</form:form>
</body>
</html>