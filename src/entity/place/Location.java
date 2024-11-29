package entity.place;

import config.Settings;
import entity.creatures.abstracts.*;
import entity.creatures.plant.Plant;
import factory.TypesCreatures;
import factory.TypesCreaturesFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static config.Settings.MAX_COUNT_PLANT;
import static factory.TypesCreatures.PLANT;

public class Location {
    private final int line;
    private final int column;
    private final List<Creature> creaturesOnLocation;
    private TypesCreaturesFactory factory;
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private final int id;


    public Location(int x, int y) {
        this.line = x;
        this.column = y;
        this.creaturesOnLocation = new ArrayList<>();
        this.factory = new TypesCreaturesFactory();
        id = COUNTER.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    public long getNumberAnimalsOnLocation(Animal animal) {
        return creaturesOnLocation.stream()
                .filter(currentType -> animal.getClass().isInstance(currentType))
                .count();
    }

    public void addCreature(Creature creature) {
        creaturesOnLocation.add(creature);
    }

    public void removeCreaturesOnIsland(Creature creature) {
        creaturesOnLocation.remove(creature);
    }

    public List<Creature> getCreaturesOnLocation() {
        return creaturesOnLocation;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public List<Animal> getAnimals() {
        return creaturesOnLocation.stream()
                .filter(animal -> animal instanceof Animal)
                .map(animal -> (Animal) animal)
                .toList();
    }

    public List<Plant> getAllPlants() {
        return creaturesOnLocation.stream()
                .filter(plants -> plants instanceof Plant)
                .map(plant -> (Plant) plant)
                .toList();
    }

    public void fillLocation() {
        for (TypesCreatures type : TypesCreatures.values()) {
            int random = ThreadLocalRandom.current().nextInt(1, factory.createCreature(type).getMaxCountOnLocation());
            for (int j = 0; j < random; j++) {
                Creature creature = factory.createCreature(type);
                creaturesOnLocation.add(creature);
            }
        }
    }

    public void growOfPlants() {
        if (getAllPlants().size() >= MAX_COUNT_PLANT) {
            return;
        }
        int random = ThreadLocalRandom.current().nextInt(0, (MAX_COUNT_PLANT - getAllPlants().size()));
        for (int j = 0; j < random; j++) {
            Creature creature = factory.createCreature(PLANT);
            creaturesOnLocation.add(creature);
        }
    }

    public void eatOnLocation() {
        for (Animal animal : getAnimals()) {
            if (!animal.getIsDead()) {
                for (Creature creatureOnLocation : creaturesOnLocation) {
                    List<Creature> creaturesForEatList = new ArrayList<>();
                    if (animal.getProbabilities().containsKey(creatureOnLocation.getName()) && !creatureOnLocation.getIsDead()) {
                        creaturesForEatList.add(creatureOnLocation);
                        Creature creatureForEat = creaturesForEatList.get((int) (Math.random() * creaturesForEatList.size()));
                        animal.eat(creatureForEat);
                    }
                }
            }
        }
        List<Creature> eatenCreatures = new ArrayList<>();
        for (Creature creature : creaturesOnLocation) {
            if (creature.getIsDead()) {
                eatenCreatures.add(creature);
            }
        }
        creaturesOnLocation.removeAll(eatenCreatures);
    }

    public void reproduceOnLocation() {
        List<Animal> reproducedList = new ArrayList<>();
        for (Animal animal : getAnimals()) {
            long numberAnimalsThisTypeOnLocation = getNumberAnimalsOnLocation(animal);
            long limit = animal.getMaxCountOnLocation() - getNumberAnimalsOnLocation(animal);
            for (Animal animalForReproduce : getAnimals()) {
                if (numberAnimalsThisTypeOnLocation >= 2 && numberAnimalsThisTypeOnLocation < limit && animal != animalForReproduce) {
                    Animal child = animal.reproduce(animalForReproduce);
                    if (animal != child) {
                        reproducedList.add(child);
                    }
                }
            }
        }
        creaturesOnLocation.addAll(reproducedList);
    }
}



