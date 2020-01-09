<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
       <title>Simple bug tracker</title>
          <link rel="stylesheet" type="text/css" href="/style.css"/>
   </head>
   <body>
   <h1>Go to <a href="<c:url value="/users/list" />">Users list</a></h1>
   </body>
</html>