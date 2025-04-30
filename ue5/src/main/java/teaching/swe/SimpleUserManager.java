package teaching.swe;

import java.util.ArrayList;
import java.util.List;

public class SimpleUserManager {
    private List<String> users = new ArrayList<String>();

    public SimpleUserManager() {
    }

    public void addUser(String name) {
        if (name == null)
            return;

        users.add(name);
    }

    public void removeUser(String name) {
        users.removeIf(user -> user.equals(name));
    }

    public List<String> getUsers() {
        return this.users;
    }
}
