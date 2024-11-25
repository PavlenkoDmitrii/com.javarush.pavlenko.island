package entity.creatures.abstracts;

import factory.TypesPredators;

public abstract class Predator extends Animal {

    public Predator(double weight, int maxCountOnLocation, String name, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation, name, maxSpeed, maxSatiety);
    }

    public static int randomPredator() {
        return (int) (Math.random() * TypesPredators.values().length);
    }
}
