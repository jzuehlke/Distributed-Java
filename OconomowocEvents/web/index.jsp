<%--
  Created by IntelliJ IDEA.
  User: Jake
  Date: 10/24/2018
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Oconomowoc Events Home</title>
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
            <div class="navbar-nav">
                <a class="navbar-brand" href="index.jsp">Oconomowoc Happenings</a>
                <a class="nav-item nav-link" href="events.jsp">Events</a>
                <a class="nav-item nav-link" href="account.jsp">Login</a>
            </div>
        </nav>
        <h1>Special Events &amp; Festivals</h1>
        <p>
            The community also hosts special events and festivals throughout the year.
            A highlight of the year is the annual Oconomowoc Festival of the Arts, one of the nation's best juried
            art fairs. Held the third weekend in August for more than 30 years, the event features music on three
            stages, food booths, children's art activities, and artwork by local and nationally-known artists.
        </p>
        <p>
            The civic groups sponsor a number of events throughout the year, including street dances in August,
            a farmer's market every Saturday from May through October, and Gallery Night events in May and October.
            On Thursday evenings throughout the summer, the Badgerland Water Ski Show Team presents free shows on
            Fowler Lake. Free Moonlit Movies concerts are held throughout the summer in the community bandshell.
            Oconomowoc's annual parades for Memorial Day, Veterans Day, Independence Day, Homecoming, Halloween,
            and Christmas celebrate the community throughout the year.
        </p>
        <p>
            Whenever you're in the Oconomowoc area, there's always something to do!
            Check out our <a href="events.jsp">Events page</a> for more information!
        </p>
        <form method="get" action="account.jsp">
            <div class="form-group">
                <label for="name">User Name:</label>
                <input type="text" class="form-control" id="name">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd">
            </div>
            <button type="submit" class="btn btn-default">Login</button>
        </form>
    </body>
</html>
