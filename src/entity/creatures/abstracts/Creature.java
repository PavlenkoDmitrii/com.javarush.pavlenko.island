package entity.creatures.abstracts;

import entity.creatures.Eatable;

public abstract class Creature implements Eatable {
    private double weight;
    private int maxCountOnLocation;
    private String name;

    public Creature(double weight, int maxCountOnLocation, String name) {
        this.weight = weight;
        this.maxCountOnLocation = maxCountOnLocation;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountOnLocation() {
        return maxCountOnLocation;
    }

    public void reproduce() {

    }
}
