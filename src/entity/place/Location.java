package entity.place;

import entity.creatures.abstracts.Animal;
import entity.creatures.abstracts.Creatures;
import entity.creatures.abstracts.Herbivore;
import entity.creatures.abstracts.Predator;

import java.util.ArrayList;
import java.util.List;

public class Location {



    private List<Creatures> creaturesOnIsland;

    public Location(List<Creatures> creaturesOnIsland) {
        this.creaturesOnIsland = new ArrayList<>();
    }

    public List<Creatures> getCreaturesOnIsland() {
        return creaturesOnIsland;
    }

    public List<Animal> getAnimals() {
        return creaturesOnIsland.stream()
                .filter(animal -> animal instanceof Animal)
                .map(animal -> (Animal) animal)
                .toList();
    }

    public List<Predator> getPredators() {
        return getAnimals().stream()
                .filter(predator -> predator instanceof Predator)
                .map(predator -> (Predator) predator)
                .toList();
    }

    public List<Herbivore> getHerbivores() {
        return getAnimals().stream()
                .filter(herbivore -> herbivore instanceof Herbivore)
                .map(herbivore -> (Herbivore) herbivore)
                .toList();
    }
}
