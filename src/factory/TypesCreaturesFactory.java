package factory;

import entity.creatures.abstracts.Creature;
import entity.creatures.animals.herbivores.*;
import entity.creatures.animals.predators.*;
import entity.creatures.plant.Plant;

public class TypesCreaturesFactory {

    public static Creature createCreature(TypesCreatures type) {

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
            case BEAR -> creatures = new Bear();
            case BOA -> creatures = new Boa();
            case EAGLE -> creatures = new Eagle();
            case FOX -> creatures = new Fox();
            case WOLF -> creatures = new Wolf();
            case PLANT -> creatures = new Plant();
            default -> throw new RuntimeException("Incorrect type");
        }
        return creatures;
    }
}
