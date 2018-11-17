package us.jake;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventServlet extends HttpServlet
{
    private String RESULT_PAGE = "account.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    } // </editor-fold>

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //get params
        String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        String ARE = request.getParameter("addRemoveEdit");
        String newName = request.getParameter("newName");
        String newDate = request.getParameter("newDate");

        //Event Lists
        EventManager events = new EventManager();
        List<Event> result = events.getEventList();

        //add event if add was checked
        if(ARE.equals("add"))
        {
            result.add(new Event(eventName, eventDate, false));
        }
        //remove event if remove was checked
        if(ARE.equals("remove"))
        {
            result.remove(events.getEventByName(eventName));
        }
        //change event name if edit was checked
        if(ARE.equals("edit"))
        {
            int eventIndex = result.indexOf(events.getEventByName(eventName));
            result.get(eventIndex).setName(newName);
            result.get(eventIndex).setDate(newDate);
        }

        //sort result list by date
        Collections.sort(result, new Comparator<Event>()
        {
            public int compare(Event e1, Event e2)
            {
                return e1.getDate().compareTo(e2.getDate());
            }
        });

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("events", result);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
}