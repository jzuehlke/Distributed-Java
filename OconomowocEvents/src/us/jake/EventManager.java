package us.jake;

import java.util.ArrayList;
import java.util.List;

public class EventManager
{
    List<Event> eventList = new ArrayList<>();

    public EventManager()
    {
        eventList.add(new Event("Christmas Parade", "12/01/2018", false));
        eventList.add(new Event("German Christmas Market", "11/23/2018", false));
        eventList.add(new Event("Fall Gallery Night", "11/02/2018", true));
        eventList.add(new Event("German Christmas Market", "11/25/2018", false));
        eventList.add(new Event("General Election", "11/06/2018", false));
        eventList.add(new Event("German Christmas Market", "11/24/2018", false));
    }

    public List<Event> getEventList()
    {
        return eventList;
    }

    public List<Event> getRemainingEvents()
    {
        List<Event> remaining = new ArrayList<>();
        for (Event e : eventList)
        {
            if (e.isCompleted())
            {
                remaining.add(e);
            }
        }
        return remaining;
    }

    @Override
    public String toString()
    {
        return "EventList{" +
                "eventList=" + eventList +
                '}';
    }
}
