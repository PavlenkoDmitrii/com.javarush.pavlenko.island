package factory;

import entity.creatures.abstracts.Creature;
import entity.creatures.animals.herbivores.*;
import entity.creatures.animals.predators.*;
import entity.creatures.plant.Plants;

public class TypesCreaturesFactory {

    public Creature createPredator(TypesPredators type) {

        Creature creatures;
        switch (type) {
            case BEAR -> creatures = new Bear();
            case BOA -> creatures = new Boa();
            case EAGLE -> creatures = new Eagle();
            case FOX -> creatures = new Fox();
            //case WOLF -> creatures = new Wolf();
            default -> throw new RuntimeException("Incorrect type");
        }
        return creatures;
    }

    public Creature createHerbivore(TypesHerbivores type) {

        Creature creatures;
        switch (type) {
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
            default -> throw new RuntimeException("Incorrect type");
        }
        return creatures;
    }

    public Creature createPlants() {
        return new Plants();
    }
}
