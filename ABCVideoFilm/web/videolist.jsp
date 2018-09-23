<%--
  Created by IntelliJ IDEA.
  User: Jake
  Date: 8/31/2018
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="us.jakezuehlke.model.*"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Videos List</title>
        <link rel="stylesheet" href="site.css" type="text/css">
    </head>

    <body>
        <div id="banner">
            <img src="images/logo.jpg" alt="logo">
        </div>

        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="videolist.jsp">Video List</a></li>
                <li><a href="cart.jsp">Cart</a></li>
            </ul>
        </nav>

        <h2 class="main-header">Featured Videos</h2>
        <br>
        <%
            //variables for ArrayList of Videos and number formatter to US dollars
            VideoLibrary vl = new VideoLibrary();
            List<Video> videos = vl.getAllTitles();
            NumberFormat formatter = NumberFormat.getCurrencyInstance();

            //begin loop through video arraylist
            for (Video video : videos)
            {
        %>
        <div class="video-repeater clearfix">
            <div class="poster">
                <a target="_blank" href="images/movieposters/<%=video.getTitle().replaceAll("[^a-zA-Z]+", "").toLowerCase()%>.jpg">
                    <img src="images/movieposters/<%=video.getTitle().replaceAll("[^a-zA-Z]+", "").toLowerCase()%>.jpg"
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
                <form method="post" action="VC">
                    <input name="title" value="<%=video.getTitle()%>" hidden>
                    <button type="submit" class="addtocart bold" value="VC">
                        Add to Cart: <%=formatter.format(video.getPrice())%>
                    </button>
                </form>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>