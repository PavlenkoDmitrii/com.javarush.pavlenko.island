package entity.place;

import entity.creatures.abstracts.*;
import factory.TypesCreatures;
import factory.TypesCreaturesFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Location {
    private int line;
    private int column;
    private List<Creature> creaturesOnLocation;
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

    private List<Animal> getAnimals() {
        return creaturesOnLocation.stream()
                .filter(animal -> animal instanceof Animal)
                .map(animal -> (Animal) animal)
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

    public void eatOnLocation() {
        for (Animal animal : getAnimals()) {
            if (!animal.getIsDead()) {
                for (Creature creatureOnLocation : creaturesOnLocation) {
                    List <Creature> creaturesForEatList = new ArrayList<>();
                    if (animal.getProbabilities().containsKey(creatureOnLocation.getName()) && !creatureOnLocation.getIsDead()) {
                        creaturesForEatList.add(creatureOnLocation);
                        Creature creatureForEat = creaturesForEatList.get((int)(Math.random() * creaturesForEatList.size()));
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
}



