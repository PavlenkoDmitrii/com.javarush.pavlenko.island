package entity.place;

import entity.creatures.abstracts.*;
import entity.creatures.plant.Plant;
import factory.TypesCreatures;
import factory.TypesCreaturesFactory;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    private final int line;
    private final int column;
    private List<Creature> creaturesOnLocation;
    private final Lock lock = new ReentrantLock(true);
    private final TypesCreaturesFactory factory;


    public Location(int x, int y) {
        this.line = x;
        this.column = y;
        this.creaturesOnLocation = new CopyOnWriteArrayList<>();
        this.factory = new TypesCreaturesFactory();
    }

    public Lock getLock() {
        return lock;
    }

    public List<Creature> getCreaturesOnLocation() {
        return creaturesOnLocation;
    }

    public void setCreaturesOnLocation(List<Creature> creaturesOnLocation) {
        this.creaturesOnLocation = creaturesOnLocation;
    }

//    public void addCreature(Creature creature) {
//        creaturesOnLocation.add(creature);
//    }
//
//    public void removeCreaturesOnIsland(Creature creature) {
//        creaturesOnLocation.remove(creature);
//    }
//
//    public int getLine() {
//        return line;
//    }
//
//    public int getColumn() {
//        return column;
//    }

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

    public long getCountAnimalsOnLocation(Animal animal) {
        return creaturesOnLocation.stream()
                .filter(currentType -> animal.getClass().isInstance(currentType))
                .count();
    }

    public void fillLocation() {
        List<Creature> temp = this.getCreaturesOnLocation();
        for (TypesCreatures type : TypesCreatures.values()) {
            int random = ThreadLocalRandom.current().nextInt(1, factory.createCreature(type).getMaxCountOnLocation());
            for (int j = 0; j < random; j++) {
                Creature creature = factory.createCreature(type);
                temp.add(creature);
            }
        }
        setCreaturesOnLocation(temp);
    }
}



