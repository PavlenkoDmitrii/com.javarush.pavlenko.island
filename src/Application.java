import entity.creatures.abstracts.Creature;
import entity.creatures.animals.predators.Fox;
import entity.creatures.animals.predators.Wolf;
import entity.creatures.plant.Plant;
import entity.place.Island;

public class Application {
    public static void main(String[] args) {

        Island island = new Island(1,1);
        island.lifeOnIsland();

    }
}
