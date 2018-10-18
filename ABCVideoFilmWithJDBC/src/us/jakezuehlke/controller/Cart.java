package us.jakezuehlke.controller;

import us.jakezuehlke.model.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet")
public class Cart extends HttpServlet
{
    private String RESULT_PAGE = "cart.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
        List<Video> videos = new ArrayList();
        videos.add(new Video(0, false, "", "", 0, 0, "", "",
                "", "", "", 0, 0, 0));
        if( cookies != null )
        {
            for (int i = 0; i < cookies.length; i++)
            {
                cookie = cookies[i];
                if (cookie.getName().equals("cartItem"))
                {
                    videos = orderedVideos( cookie.getValue( ));
                }
            }
        }
        request.setAttribute("vidLib", videos);

        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected List<Video> orderedVideos(String videoNumbers)
    {
        List<Video> items = new ArrayList<>();
        VideoLibrary vidLib = new VideoLibrary();
        String[] nums = videoNumbers.split(",");
        for (int i = 0; i < nums.length; i++)
        {
            items.add(vidLib.getSingleVideo(Integer.parseInt(nums[i])));
        }
        return items;
    }
}
