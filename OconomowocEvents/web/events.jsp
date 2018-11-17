<%--
  Created by IntelliJ IDEA.
  User: Jake
  Date: 10/29/2018
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="us.jake.EventManager" %>
<%@ page import="java.util.List" %>
<%@ page import="us.jake.ListWrapper" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Oconomowoc Events</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <ul class="nav navbar-nav">
                <li><a class="navbar-brand" href="index.jsp">Oconomowoc Happenings</a></li>
                <li><a class="nav-item nav-link" href="events.jsp">Events</a></li>
                <li><a class="nav-item nav-link" href="account.jsp">Account</a></li>
            </ul>
            <div class="dropdown ml-auto">
                <button type="button" id="dropdownMenu" data-toggle="dropdown"
                        class="btn btn-outline-secondary dropdown-toggle">Login <span class="caret"></span></button>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li>
                        <form class="form" role="form" method="post" action="login.do">
                            <div class="form-group">
                                <input name="name" placeholder="User Name" class="form-control form-control-sm"
                                       type="text" required>
                            </div>
                            <div class="form-group">
                                <input name="password" placeholder="Password" class="form-control form-control-sm"
                                       type="password" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-block">Login</button>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
        <% List list = new EventManager().getEventList(); %>
        <c:set var="listWrapper" value="<%= new ListWrapper(list) %>"/>
        <h1>Current Events</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <tr>
                    <th>Event Name</th>
                    <th>Date</th>
                </tr>
                <c:forEach var='item' items='${listWrapper.list}'>
                    <c:if test="${!item.completed}">
                        <tr>
                            <td><c:out value='${item.name}'/></td>
                            <td>
                                <fmt:parseDate pattern="MM/dd/yyyy" value="${item.date}" var="date"/>
                                <c:out value='${date}'/>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
