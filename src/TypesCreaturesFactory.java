import entity.creatures.abstracts.Creatures;
import entity.creatures.animal.herbivores.*;
import entity.creatures.animal.predators.*;
import entity.creatures.plant.Plants;

public class TypesCreaturesFactory {

    public Creatures createCreatures(TypesCreatures type) {

        Creatures creatures;
        switch (type) {
            case BEAR -> creatures = new Bear();
            case BOA -> creatures = new Boa();
            case EAGLE -> creatures = new Eagle();
            case FOX -> creatures = new Fox();
            case WOLF -> creatures = new Wolf();
            case BOAR -> creatures = new Boar();
            case BUFFALO -> creatures = new Buffalo();
            case CATERPILLAR -> creatures = new Caterpillar();
            case DEER -> creatures = new Deer();
            case DUCK -> creatures = new Duck();
            case GOAT -> creatures = new Goat();
            case HORSE -> creatures = new Horse();
            case MOUSE -> creatures = new Mouse();
            case RABBIT -> creatures = new Rabbit();
            case SHEEP -> creatures = new Sheep();
            case PLANT -> creatures = new Plants();
            default -> throw new RuntimeException("Incorrect type");
        }
        return creatures;
    }
}
