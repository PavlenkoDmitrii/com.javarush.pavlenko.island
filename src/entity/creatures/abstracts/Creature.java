package entity.creatures.abstracts;

public abstract class Creature {
    private double weight;
    private final int maxCountOnLocation;
    private final String name;
    private boolean isDead;

    public Creature(double weight, int maxCountOnLocation, String name) {
        this.weight = weight;
        this.maxCountOnLocation = maxCountOnLocation;
        this.name = name;
        this.isDead = false;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public int getMaxCountOnLocation() {
        return maxCountOnLocation;
    }

    public String getName() {
        return name;
    }

    public void die() {
        setIsDead(true);
    }
}
