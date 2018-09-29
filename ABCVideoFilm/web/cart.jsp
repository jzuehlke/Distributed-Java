<%--
  Created by IntelliJ IDEA.
  User: Jake
  Date: 8/31/2018
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="us.jakezuehlke.model.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.List" %>
<%
    //cookie stuff
    Cookie cartVideos = new Cookie("cartVideos", request.getParameter("title"));
    cartVideos.setMaxAge(60*60*24);
    response.addCookie( cartVideos );
%>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" href="site.css" type="text/css">
    </head>

    <body>
        <div id="banner">
            <img src="images/logo.jpg" alt="logo">
        </div>

        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="videolist.do">Video List</a></li>
                <li><a href="cart.jsp">Cart</a></li>
            </ul>
        </nav>

        <h2 class="main-header">Add A Classic To Your Video Library</h2>
        <div class="cartlist clearfix">
        <%
            //look for videos to add to cart, throw exception for having none
            try
            {
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                List <Video> videos = (List)request.getAttribute("cart");
                for(Video v : videos)
                {
        %>
            <div class="poster-thumb">
                <a target="_blank" href="images/movieposters/<%=v.getTitle().replaceAll("[^a-zA-Z]+", "").toLowerCase()%>.jpg">
                    <img src="images/movieposters/<%=v.getTitle().replaceAll("[^a-zA-Z]+", "").toLowerCase()%>.jpg"
                         alt="<%=v.getTitle()%>" width="100">
                </a>
            </div>
            <h3 class="detail-header bold"><%=v.getTitle()%></h3>
            <div class="cart-details">
                <%=v.getOverview()%><br><br>
                <%=formatter.format(v.getPrice())%><br><br>
            </div>

        <%
                }
        %>
            <button type="button" class="addtocart bold">Confirm Purchase</button>
        <%
            }
            catch(NullPointerException e)
            {
        %>
            Looks like you have nothing in your cart! Shop our <a href="videolist.do">Video List</a> page!
        <%
            }
        %>
        </div>
    </body>
</html>