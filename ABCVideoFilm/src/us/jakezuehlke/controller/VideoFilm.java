package us.jakezuehlke.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import us.jakezuehlke.model.*;

public class VideoFilm extends HttpServlet
{
    private static final String VIDEO_PAGE = "videolist.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");

        VideoLibrary vl = new VideoLibrary();
        List<Video> result = new ArrayList();

        for(Video v : vl.getAllTitles())
        {
            result.add(v);
        }

        request.setAttribute("videos", result);

        RequestDispatcher view = request.getRequestDispatcher(VIDEO_PAGE);
        view.forward(request, response);
    }
}