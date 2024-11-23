package entity.creatures.abstracts;

public abstract class Creatures {
    private double weight;
    private int maxCountOnLocation;

    public Creatures(double weight, int maxCountOnLocation) {
        this.weight = weight;
        this.maxCountOnLocation = maxCountOnLocation;
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
