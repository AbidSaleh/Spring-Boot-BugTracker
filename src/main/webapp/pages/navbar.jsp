<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
   <title>Users list</title>
   <link href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body><nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <span class="navbar-brand">Bugtracker</span>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/tickets/list?userId=">Tickets</a>
            </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
              <span class="navbar-text mr-sm-2">Login: ${pageContext.request.userPrincipal.name}</span>
              <a class="btn btn-outline-danger my-2 my-sm-0" href="<c:url value="/logout" />">Logout</a>
            </form>
        </div>
      </nav>

	<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>