package entity.place;

import entity.creatures.animals.herbivores.*;
import entity.creatures.animals.predators.*;
import entity.creatures.plant.Plant;

import static config.Settings.*;

public class Statistic {
    private final Location location;

    public Statistic(Location location) {
        this.location = location;
    }

    public void getStatistic() {
        int numberOfBoars = location.getCreaturesOnLocation().stream()
                .filter(boars -> boars instanceof Boar)
                .toList().size();
        int numberOfBuffaloes = location.getCreaturesOnLocation().stream()
                .filter(buffaloes -> buffaloes instanceof Buffalo)
                .toList().size();
        int numberOfCaterpillars = location.getCreaturesOnLocation().stream()
                .filter(caterpillars -> caterpillars instanceof Caterpillar)
                .toList().size();
        int numberOfDeers = location.getCreaturesOnLocation().stream()
                .filter(deers -> deers instanceof Deer)
                .toList().size();
        int numberOfDucks = location.getCreaturesOnLocation().stream()
                .filter(ducks -> ducks instanceof Duck)
                .toList().size();
        int numberOfGoats = location.getCreaturesOnLocation().stream()
                .filter(goats -> goats instanceof Goat)
                .toList().size();
        int numberOfHorses = location.getCreaturesOnLocation().stream()
                .filter(horses -> horses instanceof Horse)
                .toList().size();
        int numberOfMouses = location.getCreaturesOnLocation().stream()
                .filter(mouses -> mouses instanceof Mouse)
                .toList().size();
        int numberOfRabbits = location.getCreaturesOnLocation().stream()
                .filter(rabbits -> rabbits instanceof Rabbit)
                .toList().size();
        int numberOfSeeps = location.getCreaturesOnLocation().stream()
                .filter(sheeps -> sheeps instanceof Sheep)
                .toList().size();
        int numberOfBears = location.getCreaturesOnLocation().stream()
                .filter(bears -> bears instanceof Bear)
                .toList().size();
        int numberOfBoas = location.getCreaturesOnLocation().stream()
                .filter(boas -> boas instanceof Boa)
                .toList().size();
        int numberOfEagles = location.getCreaturesOnLocation().stream()
                .filter(eagles -> eagles instanceof Eagle)
                .toList().size();
        int numberOfFoxes = location.getCreaturesOnLocation().stream()
                .filter(foxes -> foxes instanceof Fox)
                .toList().size();
        int numberOfWolfs = location.getCreaturesOnLocation().stream()
                .filter(wolfs -> wolfs instanceof Wolf)
                .toList().size();
        int numberOfPlants = location.getCreaturesOnLocation().stream()
                .filter(plants -> plants instanceof Plant)
                .toList().size();

        System.out.println("[On location " + location.getId() + ": " +
                BOAR_NAME + " " + numberOfBoars + " " +
                BUFFALO_NAME + " " + numberOfBuffaloes + " " +
                CATERPILLAR_NAME + " " + numberOfCaterpillars + " " +
                DEER_NAME + " " + numberOfDeers + " " +
                DUCK_NAME + " " + numberOfDucks + " " +
                GOAT_NAME + " " + numberOfGoats + " " +
                HORSE_NAME + " " + numberOfHorses + " " +
                MOUSE_NAME + " " + numberOfMouses + " " +
                RABBIT_NAME + " " + numberOfRabbits + " " +
                SHEEP_NAME + " " + numberOfSeeps + " " +
                BEAR_NAME + " " + numberOfBears + " " +
                BOA_NAME + " " + numberOfBoas + " " +
                EAGLE_NAME + " " + numberOfEagles + " " +
                FOX_NAME + " " + numberOfFoxes + " " +
                WOLF_NAME + " " + numberOfWolfs + " " +
                PLANT_NAME + " " + numberOfPlants + "]");
    }

}
