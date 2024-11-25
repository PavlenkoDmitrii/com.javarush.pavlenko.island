package entity.creatures.abstracts;

import entity.creatures.Eatable;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class Animal extends Creature {

    private int maxSpeed;
    private double maxSatiety;

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

    public HashMap<String, Integer> getProbabilities() {
        return null;
    }

    public void eat(Eatable eatable) {
        HashMap<String, Integer> probabilities = this.getProbabilities();
        for (Map.Entry<String, Integer> entry : probabilities.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(eatable.getClass().getSimpleName())) {
                int chanceToEat = (int) (Math.random() * 100);
                if (entry.getValue() > chanceToEat) {
                    eatable.die();
                }
            }
        }
    }

    public void chooseDirection() {
    }

    public void move() {
    }

}
