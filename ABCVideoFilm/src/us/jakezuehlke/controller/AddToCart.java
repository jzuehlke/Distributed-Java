package us.jakezuehlke.controller;

import us.jakezuehlke.model.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddToCart extends HttpServlet
{
    private static final String CART_PAGE = "cart.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");

        // parameters are name attributes in view pages
        // Here we're retrieving form content from videolist.jsp
        String title = request.getParameter("title");

        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        VideoLibrary vl = new VideoLibrary();

        // Always a good idea to trim and/or validate input data
        List<Video> result = new ArrayList();
        result.add(vl.getVideoByTitle(title.trim()));

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("cart", result);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view = request.getRequestDispatcher(CART_PAGE);
        view.forward(request, response);
    }
}