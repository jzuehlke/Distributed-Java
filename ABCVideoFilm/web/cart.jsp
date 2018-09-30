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
    Cookie titles = new Cookie("titles", request.getParameter("title"));
    titles.setMaxAge(60*60*24);
    response.addCookie( titles );
%>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" href="site.css" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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

        <h2 class="main-header">
            Add A Classic To Your Video Library &nbsp;

            <!-- Trigger/Open The Modal -->
            <button type="button" id="myBtn" class="addtocart bold">Confirm Purchase</button>
        </h2>

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
            }
            catch(NullPointerException e)
            {
        %>
            Looks like you have nothing in your cart! Shop our <a href="videolist.do">Video List</a> page!
        <%
            }
        %>
        </div>

        <!-- The Modal -->
        <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content">
                <div class="modal-header">
                    <span class="close">&times;</span>
                    <h2>Your Purchased Videos</h2>
                </div>
                <div class="modal-body">
                    <%
                        Cookie cookie = null;
                        Cookie[] cookies = null;
                        cookies = request.getCookies();
                        if( cookies != null )
                        {
                    %>
                    <h3>Found Cookies Name and Value</h3>
                    <%
                            for (int i = 0; i < cookies.length; i++)
                            {
                                cookie = cookies[i];
                    %>
                    <p>
                        Name: <%=cookie.getName()%><br>
                        Value: <%=cookie.getValue()%><br>
                    </p>
                    <%
                            }
                        }
                        else
                        {
                    %>
                    <p>
                        Looks like you have nothing in your cart!
                        Shop our <a href="videolist.do">Video List</a> page!
                    </p>
                    <%
                        }
                    %>
                </div>
                <div class="modal-footer">
                    <h3>Thank you for choosing ABC VideoFilms!</h3>
                </div>
            </div>
        </div>

        <script>
            // Get the modal
            var modal = document.getElementById('myModal');

            // Get the button that opens the modal
            var btn = document.getElementById("myBtn");

            // Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];


            // When the user clicks the button, open the modal
            btn.onclick = function()
            {
                modal.style.display = "block";
            }

            // When the user clicks on <span> (x), close the modal
            span.onclick = function()
            {
                modal.style.display = "none";
            }

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event)
            {
                if (event.target == modal)
                {
                    modal.style.display = "none";
                }
            }
        </script>
    </body>
</html>