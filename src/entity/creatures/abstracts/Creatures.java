package entity.creatures.abstracts;

public abstract class Creatures {
    private double weight;
    private int maxCountOnLocation;
    private String name;

    public Creatures(double weight, int maxCountOnLocation, String name) {
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
