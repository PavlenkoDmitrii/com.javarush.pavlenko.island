package entity.place;

import entity.creatures.abstracts.*;
import factory.TypesCreatures;
import factory.TypesCreaturesFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Location {
    private List<Creature> creaturesOnIsland;
    private TypesCreaturesFactory factory;


    public Location() {
        this.creaturesOnIsland = new ArrayList<>();
        this.factory = new TypesCreaturesFactory();
    }

    public void addCreature(Creature creature) {
        creaturesOnIsland.add(creature);
    }

    public void removeCreaturesOnIsland(Creature creature) {
        creaturesOnIsland.remove(creature);
    }

    public List<Creature> getCreaturesOnIsland() {
        return creaturesOnIsland;
    }

//    public int getLine() {
//        return line;
//    }
//
//    public int getColumn() {
//        return column;
//    }

    public List<Animal> getAnimals() {
        return creaturesOnIsland.stream()
                .filter(objectIslands -> objectIslands instanceof Animal)
                .map(objectIslands -> (Animal) objectIslands)
                .toList();
    }

    public void fillLocation() {
        StringBuilder statistic = new StringBuilder();
        for (TypesCreatures type : TypesCreatures.values()) {
            int random = (int) (Math.random() * factory.createCreature(type).getMaxCountOnLocation());
            Creature creature = factory.createCreature(type);
            int count = 0;
            for (int j = 0; j < random; j++) {
                creaturesOnIsland.add(creature);
                count++;
            }
            statistic.append(creature.getClass().getSimpleName()).append(" -> ").append(count).append(" ");
        }
        System.out.println("[ " + statistic + "]");
        System.out.println(creaturesOnIsland.size());
    }

    public void eatOnLocation() {
        for (Animal animal : getAnimals()) {
            Creature creatureOnIsland = creaturesOnIsland.get((int) (Math.random() * getCreaturesOnIsland().size()));
            animal.eat(creatureOnIsland);
        }
        List<Creature> eatedAnimals = new ArrayList<>();
        for (Creature creature : creaturesOnIsland) {
            if (creature.getIsEaten()) {
                eatedAnimals.add(creature);
            }
        }
        creaturesOnIsland.removeAll(eatedAnimals);
        System.out.println(creaturesOnIsland.size());

    }
}



