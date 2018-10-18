package us.jakezuehlke.model;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

public class VideoCookies
{
    private static List<Cookie> cookies = new ArrayList<>();

    public VideoCookies() {
    }

    public List getCookies()
    {
        return cookies;
    }

    public void addCookie(Cookie c)
    {
        cookies.add(c);
    }

    public void removeCookie(Cookie c)
    {
        cookies.remove(c);
    }
}
