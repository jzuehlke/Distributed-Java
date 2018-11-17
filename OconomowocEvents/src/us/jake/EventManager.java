package us.jake;

import java.util.ArrayList;
import java.util.List;

public class EventManager
{
    private static List<Event> eventList = new ArrayList<>();

    public EventManager()
    {
        if(eventList.size() == 0)
        {
            eventList.add(new Event("Christmas Parade", "12/01/2018", false));
            eventList.add(new Event("German Christmas Market day 1", "11/23/2018", false));
            eventList.add(new Event("Fall Gallery Night", "11/02/2018", true));
            eventList.add(new Event("German Christmas Market day 3", "11/25/2018", false));
            eventList.add(new Event("General Election", "11/06/2018", true));
            eventList.add(new Event("German Christmas Market day 2", "11/24/2018", false));
        }
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

    public Event getEventByName(String name)
    {
        Event e = null;
        for(int i = 0; i < eventList.size(); i++)
        {
            if(eventList.get(i).getName().equals(name))
            {
                e = eventList.get(i);
            }
        }
        return e;
    }

    @Override
    public String toString()
    {
        return "EventList{" +
                "eventList=" + eventList +
                '}';
    }
}
