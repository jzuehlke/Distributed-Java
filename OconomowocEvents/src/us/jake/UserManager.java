package us.jake;

import java.util.ArrayList;
import java.util.List;

public class UserManager
{
    List<User> userList = new ArrayList<>();

    public UserManager()
    {
        userList.add(new User("Jake","Zuehlke"));
        userList.add(new User("admin", "admin123"));
    }

    public List<User> getUserList()
    {
        return userList;
    }

    @Override
    public String toString()
    {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}
