import java.util.Optional;

public class NpeTest {

    public static void main(String[] args) {
        Human humanFromDb = getHumanFromDb(8);

        if (humanFromDb != null) {
            System.out.println("humanFromDb.toString() = " + humanFromDb.toString());
        }

        Optional<Human> humanFromDbOpt = getHumanFromDbOpt(22);
        System.out.println("humanFromDbOpt.isPresent() = " + humanFromDbOpt.isPresent());
        System.out.println("humanFromDbOpt.isEmpty() = " + humanFromDbOpt.isEmpty());

        //humanFromDbOpt.get();
        Human human = humanFromDbOpt.orElseGet(() -> {
            //get human from file system
            return new Human();
        });
        Human human1 = humanFromDbOpt.orElse(new Human());
        humanFromDbOpt.orElseThrow(() -> {
            return new IllegalArgumentException("asd");
        });
        humanFromDbOpt.ifPresentOrElse((h) -> {
            //send to кафедра
        }, () -> {
            //send error record to analist service that human is missed
                });
        //humanFromDbOpt.map()
        Optional<Human> ivan = humanFromDbOpt.filter((h) -> h.getName().equals("Ivan"));
    }

    public static Human getHumanFromDb(int id) {
        if (id == 1) {
            return new Human();
        }
        return null;
    }

    public static Optional<Human> getHumanFromDbOpt(int id) {
        if (id == 1) {
            Human human1 = new Human();
            Optional<Human> humanOpt = Optional.of(human1);
            return humanOpt;
        }
        return Optional.empty();
    }
}
