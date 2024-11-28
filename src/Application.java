import entity.creatures.abstracts.Creature;
import entity.creatures.animals.predators.Fox;
import entity.creatures.animals.predators.Wolf;
import entity.creatures.plant.Plant;
import entity.place.Island;

public class Application {
    public static void main(String[] args) {

        Island island = new Island(1,1);
        island.lifeOnIsland();

        Creature plant = new Plant();
        Creature plant1 = new Plant();
        Creature wolf = new Wolf();
        Creature wolf1 = new Wolf();
        Creature fox = new Fox();
        Creature fox1 = new Fox();

        Creature creature = fox.reproduce(fox1);
        System.out.println(fox == creature);
    }
}
