package entity;

public abstract class Animals {

    private double weight;
    private int maxSpeed;
    private double maxSatiety;
    private double actualSatiety;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public void setMaxSatiety(double maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public double getActualSatiety() {
        return actualSatiety;
    }

    public void setActualSatiety(double actualSatiety) {
        this.actualSatiety = actualSatiety;
    }

    public abstract void worker();

    public abstract void eat();

    public abstract void chooseDirection();

    public abstract void move();

    public abstract void reproduce();

    public abstract void die();
}
