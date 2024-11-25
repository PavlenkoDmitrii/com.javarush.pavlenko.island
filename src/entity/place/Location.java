package entity.place;

import entity.creatures.abstracts.Animal;
import entity.creatures.abstracts.Creature;
import entity.creatures.abstracts.Herbivore;
import entity.creatures.abstracts.Predator;
import factory.TypesCreaturesFactory;

import java.util.ArrayList;
import java.util.List;

import static config.Settings.*;
import static entity.creatures.abstracts.Herbivore.randomHerbivore;
import static entity.creatures.abstracts.Predator.randomPredator;
import static factory.TypesHerbivores.getHerbivoreByID;
import static factory.TypesPredators.getPredatorByID;


public class Location {

    private List<Creature> creaturesOnIsland;

    public Location() {
        this.creaturesOnIsland = new ArrayList<>();
    }

    public List<Creature> getCreaturesOnIsland() {
        return creaturesOnIsland;
    }

    TypesCreaturesFactory typesCreaturesFactory = new TypesCreaturesFactory();

    private List<Predator> createPredators() {
        List<Predator> predatorList = new ArrayList<>();
        for (int i = 0; i < NUMBER_PREDATORS_IN_LOCATION_AT_START; i++) {
            predatorList.add((Predator) typesCreaturesFactory.createPredator
                    (getPredatorByID(randomPredator())));
        }
        return predatorList;
    }

    private List<Herbivore> createHerbivores() {
        List<Herbivore> herbivoreList = new ArrayList<>();
        for (int i = 0; i < NUMBER_HERBIVORES_IN_LOCATION_AT_START; i++) {
            herbivoreList.add((Herbivore) typesCreaturesFactory.createHerbivore
                    (getHerbivoreByID(randomHerbivore())));
        }
        return herbivoreList;
    }


    public List<Animal> getAnimals() {
        List<Predator> predators = createPredators();
        List<Herbivore> herbivores = createHerbivores();
        creaturesOnIsland.addAll(predators);
        creaturesOnIsland.addAll(herbivores);

        return creaturesOnIsland.stream()
                .filter(animal -> animal instanceof Animal)
                .map(animal -> (Animal) animal)
                .toList();
    }
}


