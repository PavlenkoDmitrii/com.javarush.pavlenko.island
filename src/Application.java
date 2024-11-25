import entity.creatures.abstracts.Animal;
import entity.creatures.animals.herbivores.Mouse;
import entity.creatures.animals.predators.Wolf;

public class Application {
    public static void main(String[] args) {
        Animal wolf = new Wolf();
        Animal mouse = new Mouse();

        wolf.eat(mouse);

    }
}