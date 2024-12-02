package entity.creatures.abstracts;

import entity.place.Location;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static config.Settings.FOOD_VALUE;

public abstract class Animal extends Creature {

    private final int maxSpeed;
    private final double maxSatiety;
    private double actualSatiety;
    private boolean isEat;
    private boolean isReproduce;

    public Animal(double weight, int maxCountOnLocation, String name, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation, name);
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
        this.actualSatiety = (this.getMaxSatiety() / 6);
        this.isEat = false;
        this.isReproduce = false;
    }

    public boolean isEat() {
        return isEat;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public double getActualSatiety() {
        return actualSatiety;
    }

    public void setActualSatiety(double actualSatiety) {
        this.actualSatiety = actualSatiety;
    }

    private boolean isReproduce() {
        return isReproduce;
    }

    private void starvation() {
        setActualSatiety(getActualSatiety() / 6);
        if ((int) getActualSatiety() == 0) {
            this.die();
        }
    }

    public void starvationOnLocation(Location location) {
        List<Creature> temp = location.getCreaturesOnLocation();
        List<Animal> listForDead = new ArrayList<>();
        this.starvation();
        if (this.getIsDead()) {
            listForDead.add(this);
        }
        temp.removeAll(listForDead);
        location.setCreaturesOnLocation(temp);
    }

    public abstract HashMap<String, Integer> getProbabilities();

    private boolean canEat(Creature creature) {
        return !creature.getIsDead() && this.actualSatiety < this.getMaxSatiety() && !this.isEat;
    }

    private void eat(Creature creature) {
        if (!canEat(creature) || !this.getProbabilities().containsKey(creature.getName())) {
            return;
        }
        this.isEat = false;
        int probabilityToEat = ThreadLocalRandom.current().nextInt(0, 100);
        int probabilityOfEaten = this.getProbabilities().get(creature.getName());
        if (probabilityToEat <= probabilityOfEaten) {
            if (this.getMaxSatiety() < 1) {
                this.actualSatiety = this.getMaxSatiety();
            } else {
                this.actualSatiety += FOOD_VALUE;
            }
            this.isEat = true;
            creature.die();
        }
    }

    public void eatOnLocation(Location location) {
        List<Creature> temp = location.getCreaturesOnLocation();
        if (!this.getIsDead()) {
            for (Creature creatureOnLocation : location.getCreaturesOnLocation()) {
                List<Creature> creaturesForEatList = new ArrayList<>();
                if (this.getProbabilities().containsKey(creatureOnLocation.getName()) && !creatureOnLocation.getIsDead()) {
                    creaturesForEatList.add(creatureOnLocation);
                    Creature creatureForEat = creaturesForEatList.get((int) (Math.random() * creaturesForEatList.size()));
                    this.eat(creatureForEat);
                }
            }
        }
        List<Creature> eatenCreatures = new ArrayList<>();
        for (Creature creature : location.getCreaturesOnLocation()) {
            if (creature.getIsDead()) {
                eatenCreatures.add(creature);
            }
        }
        temp.removeAll(eatenCreatures);
        location.setCreaturesOnLocation(temp);
    }

    private boolean canReproduce(Animal animal) {
        return this.getClass().getSimpleName().equalsIgnoreCase(animal.getClass().getSimpleName()) &&
                !this.getIsDead() && !animal.getIsDead() &&
                !this.isReproduce && !animal.isReproduce;
    }

    private Animal reproduce(Animal animal) {
        if (canReproduce(animal)) {
            try {
                this.isReproduce = true;
                return this.getClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException("New instance is corrupted!");
            }
        }
        return this;
    }

    public void reproduceOnLocation(Location location) {
        List<Creature> temp = location.getCreaturesOnLocation();
        List<Animal> reproducedList = new ArrayList<>();
        if (!this.isReproduce()) {
            long countAnimalsThisTypeOnLocation = location.getCountAnimalsOnLocation(this);
            long limit = this.getMaxCountOnLocation() - location.getCountAnimalsOnLocation(this);
            for (Animal animalForReproduce : location.getAnimals()) {
                if (countAnimalsThisTypeOnLocation >= 2 && countAnimalsThisTypeOnLocation < limit && this != animalForReproduce) {
                    Animal child = this.reproduce(animalForReproduce);
                    if (this != child) {
                        reproducedList.add(child);
                    }
                }
            }
            temp.addAll(reproducedList);
            location.setCreaturesOnLocation(temp);
        }
    }
}

//    private Location forwardStep(Location thisLocation, Island island) {
//        int thisLine = thisLocation.getLine();
//        int thisColumn = thisLocation.getColumn();
//        if (thisLine > 0) {
//            Location newLocation = island.getLocations()[thisLine - 1][thisColumn];
//            newLocation.addCreature(this);
//            thisLocation.removeCreature(this);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    private Location backStep(Location thisLocation, Island island) {
//        int thisLine = thisLocation.getLine();
//        int thisColumn = thisLocation.getColumn();
//        if (thisLine < island.getCountOfLines() - 1) {
//            Location newLocation = island.getLocations()[thisLine + 1][thisColumn];
//            newLocation.addCreature(this);
//            thisLocation.removeCreature(this);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    private Location leftStep(Location thisLocation, Island island) {
//        int thisLine = thisLocation.getLine();
//        int thisColumn = thisLocation.getColumn();
//        if (thisColumn > 0) {
//            Location newLocation = island.getLocations()[thisLine][thisColumn - 1];
//            newLocation.addCreature(this);
//            thisLocation.removeCreature(this);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    private Location rightStep(Location thisLocation) {
//        int thisRow = thisLocation.getLine();
//        int thisColumn = thisLocation.getColumn();
//        if (thisColumn < island.getCountOfColumns() - 1) {
//            Location newLocation = island.getLocations()[thisRow][thisColumn + 1];
//            newLocation.addCreature(this);
//            thisLocation.removeCreature(this);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    public void move(Location location, Island island) {
//        int numberSteps = ThreadLocalRandom.current().nextInt(0, this.getMaxSpeed());
//        while (numberSteps > 0) {
//            DirectionOfMovement direction = DirectionOfMovement.values()[numberSteps];
//            switch (direction) {
//                case FORWARD -> location = forwardStep(location, island);
//                case BACK -> location = backStep(location, island);
//                case LEFT -> location = leftStep(location, island);
//                case RIGHT -> location = rightStep(location, island);
//            }
//            numberSteps--;
//        }
//    }
//}
