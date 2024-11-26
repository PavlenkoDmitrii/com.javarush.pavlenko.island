package entity.creatures.abstracts;

import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Creature {

    private int maxSpeed;
    private double maxSatiety;
    private double actualSatiety;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public Animal(double weight, int maxCountOnLocation, String name, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation, name);
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
    }

    public void worker() {
    }

    public abstract HashMap<String, Integer> getProbabilities();

    public void eat(Creature creature) {
        if (!creature.getIsEaten()) {
            HashMap<String, Integer> probabilities = this.getProbabilities();
            for (Map.Entry<String, Integer> entry : probabilities.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(creature.getClass().getSimpleName())) {
                    int chanceToEat = (int) (Math.random() * 100);
                    if (entry.getValue() >= chanceToEat) {
                        creature.die();
                    }
                }
            }
        }
    }

    public void chooseDirection() {
    }

    public void move() {
    }

    @Override
    public void reproduce() {

    }
}
