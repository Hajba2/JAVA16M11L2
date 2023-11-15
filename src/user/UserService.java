package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private List<User> users;
    public UserService() {
        this.users = new ArrayList<>();
        users.add(new User("Ivan", "Ivan@gmail"));
        users.add(new User("Sveta", "Sveta@gmail"));
    }
    public User add(String name, String email) {
        User user = new User(name, email);
        users.add(user);
        return user;
    }
    public User search(String searchBy) {
        String sLowerCase = searchBy.toLowerCase();
        for (User u : users) {
            if (u.getName().toLowerCase().contains(sLowerCase) ||
                    u.getEmail().toLowerCase().contains(sLowerCase)) {
                return u;
            }
        }
        return null;
    }
    public Optional<User> searchFunctionalStyle(String searchBy) {
        String sLowerCase = searchBy.toLowerCase();
        return users.stream()
                .filter(u -> u.getName().toLowerCase().contains(sLowerCase) ||
                        u.getEmail().toLowerCase().contains(sLowerCase))
                .findFirst();
    }
}
