package entity.creatures.abstracts;

import entity.place.Location;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static config.Settings.FOOD_VALUE;

public abstract class Animal extends Creature {

    private int maxSpeed;
    private double maxSatiety;
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

    public boolean isReproduce() {
        return isReproduce;
    }

    public void starvation() {
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

    public void eat(Creature creature) {
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

    public Animal reproduce(Animal animal) {
        if (canReproduce(animal)) {
            try {
                this.isReproduce = true;
                return this.getClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
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

    public void chooseDirection() {
    }

    public void move() {
    }
}
