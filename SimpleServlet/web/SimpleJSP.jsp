<%--
  Created by IntelliJ IDEA.
  User: Jake
  Date: 9/12/2018
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="edu.wctc.simple.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Simple JSP</title>
</head>
<body>
    <h1>Simple JSP</h1>

    <table border="1">
        <th>Account #</th>
        <th>First Name</th>
        <th>Last Name</th>
        <%
            Students theStudents = new Students();
            FindColumns fc = FindColumns.ACCTNUM;
            ArrayList<Individual> result;
            String radioValue = request.getParameter("search");
            String searchValue = request.getParameter("text-input");
            result = theStudents.findStudents(fc.getColumns(radioValue), searchValue);
            for(Individual i: result)
            {
                out.println("<tr><td>" + i.getAccountNumber() + "</td><td>" + i.getFname() + "</td><td>" + i.getLname() + "</td></tr>");
            }
        %>
    </table>
</body>
</html>
