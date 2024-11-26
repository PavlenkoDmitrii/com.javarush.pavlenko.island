package entity.creatures.abstracts;

public abstract class Predator extends Animal {

    public Predator(double weight, int maxCountOnLocation, String name, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation, name, maxSpeed, maxSatiety);
    }
}
