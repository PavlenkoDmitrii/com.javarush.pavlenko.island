package entity.creatures.abstracts;

import entity.creatures.Eatable;

import java.util.HashMap;

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

    public HashMap<Eatable, Integer> getProbabilities(){
        return null;
    }

    public void eat(Eatable eatable) {
        //???
    }

    public void chooseDirection() {
    }

    public void move() {
    }

    public void die() {
        //remove
    }

}
