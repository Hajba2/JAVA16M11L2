package user;

import java.util.Optional;

public class UserServiceTest {

    public static void main(String[] args) {
        UserService us = new UserService();

        User ivan = us.search("Ivan");
        Optional<User> ivanO = us.searchFunctionalStyle("Ivan");

        User ivan2 = us.search("Ivan2");
        Optional<User> ivanO2 = us.searchFunctionalStyle("Ivan2");

        if (ivan2 != null) {
            //send to the doctor
        } {
            //request Ivan data from file system
        }

        ivanO2.ifPresentOrElse((u) -> {/*send to the doctor*/}, () -> {/*request Ivan data from file system*/});

    }
}
