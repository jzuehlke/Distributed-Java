<%--
  Created by IntelliJ IDEA.
  User: Jake
  Date: 8/31/2018
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.jakezuehlke.model.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>ABC VideoFilm</title>
        <link rel="stylesheet" href="css/site.css" type="text/css">
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

        <h2 class="main-header">ABC VideoFilm, A Place For Classics</h2>

        <p id="home-intro">
            Here at ABC VideoFilm we believe VHS is a superior, timeless format.  Because of this simple belief,
            all videos for purchase on our site are in VHS format and VHS format only.  Because some videos are
            newer, it may cost a little extra to purchase a VHS due to conversion from DVD.
        </p>

        <h2 class="main-header">Video of the Month:</h2>
        <div class="video-repeater clearfix">
            <%
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                List recs = (List) request.getAttribute("vidLib");
                Iterator it = recs.iterator();
                while (it.hasNext())
                {
                    Video video = (Video) it.next();
            %>
            <div class="poster">
                <a target="_blank" href="<%=video.getImage()%>">
                    <img src="<%=video.getImage()%>"
                         alt="<%=video.getTitle()%>" height="400">
                </a>
            </div>
            <div class="details">
                <h3 class="detail-header bold">
                    <%=video.getTitle()%> (<%=video.getYear()%>) <%=video.getRating()%>/10 <%=video.getAdvisory()%>
                </h3>
                <p>
                    <span class="bold">Overview:</span><br>
                    <%=video.getOverview()%><br><br>
                    <span class="bold">Summary:</span><br>
                    <%=video.getStoryline()%><br><br>
                    <span class="bold">Country: </span><%=video.getCountry()%><br>
                    <span class="bold">Language: </span><%=video.getLanguage()%><br>
                    <span class="bold">Budget: </span><%=formatter.format(video.getBudget())%><br>
                    <span class="bold">Runtime: </span><%=video.getRuntime()%> minutes<br>
                </p>
                <form method="get" action="cartplace.do">
                    <input name="cartItem" value="<%=video.getVideoNum()%>" hidden>
                    <button type="submit" class="addtocart bold" value="Purchase">
                        Add to Cart: <%=formatter.format(video.getPrice())%>
                    </button>
                </form>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>