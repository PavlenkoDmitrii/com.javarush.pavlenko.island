package entity.creatures.abstracts;

public abstract class Animal extends Creatures {

    private int maxSpeed;
    private double maxSatiety;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public Animal(double weight, int maxCountOnLocation, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation);
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
    }

    public void worker(){

    }

    public void eat() {

    }

    public void chooseDirection() {

    }

    public void move() {

    }

    public void die() {

    }

}
