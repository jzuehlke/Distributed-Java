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
<%@ page import="java.util.Iterator" %>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" href="css/site.css" type="text/css">
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
                <li><a href="cart.do">Cart</a></li>
            </ul>
        </nav>

        <h2 class="main-header">Add A Classic To Your Video Library</h2>

        <div id="wrapper">
            <div class="cartlist clearfix">
            <%
                double total = 0;
                NumberFormat formatter = NumberFormat.getCurrencyInstance();

                //look for videos to add to cart, throw exception for having none
                try
                {
                    List recs = (List) request.getAttribute("vidLib");
                    Iterator it = recs.iterator();

                    while (it.hasNext())
                    {
                        Video video = (Video) it.next();
            %>
                <div class="poster-thumb">
                    <a target="_blank" href="<%=video.getImage()%>">
                        <img src="<%=video.getImage()%>"
                             alt="<%=video.getTitle()%>" width="100">
                    </a>
                </div>
                <h3 class="detail-header bold"><%=video.getTitle()%></h3>
                <div class="cart-details">
                    <%=video.getOverview()%><br><br>
                    <%=formatter.format(video.getPrice())%><br><br>
                </div>

            <%
                        total += video.getPrice();
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
            <br>
            <div class="cartlist clearfix">
                <p>Order Total: <%=formatter.format(total)%></p>
                <!-- Trigger/Open The Modal -->
                <button type="button" id="myBtn" class="addtocart bold" value="Complete Order">Confirm Purchase</button>
            </div>
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
                        List recs = (List) request.getAttribute("vidLib");
                        Iterator it = recs.iterator();

                        while (it.hasNext())
                        {
                            Video video = (Video) it.next();
                    %>
                    <h3 class="detail-header bold"><%=video.getTitle()%></h3>
                    <div class="cart-details">
                        <%=formatter.format(video.getPrice())%><br><br>
                    </div>
                    <%
                        }
                    %>
                    <div class="cart-details">
                        Order Total: <%=formatter.format(total)%>
                    </div>
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