package entity.creatures.abstracts;

public abstract class Creature {
    private double weight;
    private int maxCountOnLocation;
    private String name;
    private boolean isEaten;

    public Creature(double weight, int maxCountOnLocation, String name) {
        this.weight = weight;
        this.maxCountOnLocation = maxCountOnLocation;
        this.name = name;
        this.isEaten = false;
    }

    public boolean getIsEaten() {
        return isEaten;
    }

    public void setIsEaten(boolean eaten) {
        isEaten = eaten;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountOnLocation() {
        return maxCountOnLocation;
    }

    public String getName() {
        return name;
    }

    public abstract void reproduce();

    public void die() {
        setIsEaten(true);
    }
}
