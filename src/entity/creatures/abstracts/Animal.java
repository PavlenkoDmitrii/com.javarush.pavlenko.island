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

    public Animal(double weight, int maxCountOnLocation, String name, int maxSpeed, double maxSatiety) {
        super(weight, maxCountOnLocation, name);
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
    }

    public void worker() {

    }

    public void eat(Creatures typeOfEatable, int probability) {
        if (probability > 30) {
            System.out.println(this.getClass().getSimpleName() +
                    " cъел " +
                    typeOfEatable.getClass().getSimpleName());
        }
    }

        public void chooseDirection () {

        }

        public void move () {

        }

        public void die () {

        }

    }
