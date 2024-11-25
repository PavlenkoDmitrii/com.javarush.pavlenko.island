package entity.creatures.abstracts;

import factory.TypesHerbivores;

public abstract class Herbivore extends Animal {

    public Herbivore(double weight, int maxCountOnLocation, String name, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation, name, maxSpeed, maxSatiety);
    }

    public static int randomHerbivore() {
        return (int) (Math.random() * TypesHerbivores.values().length);
    }
}
