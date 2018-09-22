<%--
  Created by IntelliJ IDEA.
  User: Jake
  Date: 8/31/2018
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@ page import="us.jakezuehlke.model.*"%>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" href="site.css" type="text/css">
    </head>

    <body>
        <div id="banner">
            <img src="logo.jpg" alt="logo">
        </div>

        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="videolist.jsp">Videos List</a></li>
                <li><a href="cart.jsp">Cart</a></li>
            </ul>
        </nav>

        <h2 class="main-header">Add A Classic To Your Video Library</h2>
        <p id="cartlist">
            <%
                try
                {
                    List recs = (List) request.getAttribute("cart");
                    Iterator it = recs.iterator();
                    while (it.hasNext()) {
                        out.print("Your video: " + it.next() + "<br>");
                    }
                }
                catch(NullPointerException e)
                {
                    out.print("Looks like you have nothing in your cart! Shop our Video List page!");
                }
            %>
        </p>
    </body>
</html>