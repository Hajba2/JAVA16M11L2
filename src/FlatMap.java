import user.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) {
        List<User> users1 = new ArrayList<>();
        users1.add(new User("Ivan1", "Ivan1@gmail"));
        users1.add(new User("Sveta", "Sveta@gmail"));

        List<User> users2 = new ArrayList<>();
        users2.add(new User("Ivan2", "Ivan2@gmail"));
        users2.add(new User("Sveta", "Sveta@gmail"));

        List<List<User>> lists = List.of(users1, users2);

        Map<String, User> res = lists.stream()
                .flatMap(Collection::stream)
                .filter(u -> u.getName().startsWith("I"))
                .collect(Collectors.toMap(
                        u -> u.getEmail(),
                        Function.identity()
                ));

        AtomicInteger i = new AtomicInteger(0);

        //int j = 0;

        String collect = lists.stream()
                .flatMap(Collection::stream)
                .map(u -> u.getName() + " " + i.get())
                .filter(s -> {
                    //return j % 2 == 0;
                    return i.getAndIncrement() % 2 == 0;
                })
                .collect(Collectors.joining(", "));
        System.out.println(collect);
    }
}
