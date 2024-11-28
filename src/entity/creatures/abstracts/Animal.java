package entity.creatures.abstracts;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static config.Settings.FOOD_VALUE;

public abstract class Animal extends Creature {

    private int maxSpeed;
    private double maxSatiety;
    private double actualSatiety;
    private boolean isEat;

    public Animal(double weight, int maxCountOnLocation, String name, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation, name);
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
        this.actualSatiety = (this.getMaxSatiety() / 2.0);
        this.isEat = false;
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

//    public void worker() {
//        actualSatiety--;
//    }

    public abstract HashMap<String, Integer> getProbabilities();

    private boolean canEat(Creature creature) {
        return !creature.getIsDead() && this.actualSatiety != this.getMaxSatiety() && !this.isEat;
    }

    public void eat(Creature creature) {
        this.isEat = false;
        if (!canEat(creature) || !this.getProbabilities().containsKey(creature.getName())) {
            return;
        }
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

    private boolean canReproduce(Creature creature) {
        return this.getClass().getSimpleName().equalsIgnoreCase(creature.getClass().getSimpleName()) &&
                !this.getIsDead() && !creature.getIsDead();
    }

    @Override
    public Creature reproduce(Creature creature) {
        if (canReproduce(creature)) {
            try {
                return this.getClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public void chooseDirection() {
    }

    public void move() {
    }
}
