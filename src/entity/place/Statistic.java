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

    public int getNumberOfCreature(){
        return location.getCreaturesOnLocation().stream()
                .filter(creature -> this.getClass().getSimpleName().equalsIgnoreCase(creature.getName()))
                .toList().size();
    }

    public int getNumberOfBoars(){
        return location.getCreaturesOnLocation().stream()
                .filter(boars -> boars instanceof Boar)
                .toList().size();
    }
    public int getNumberOfBuffaloes(){
        return location.getCreaturesOnLocation().stream()
                .filter(buffaloes -> buffaloes instanceof Buffalo)
                .toList().size();
    }
    public int getNumberOfCaterpillars(){
        return location.getCreaturesOnLocation().stream()
                .filter(caterpillars -> caterpillars instanceof Caterpillar)
                .toList().size();
    }
    public int getNumberOfDeers(){
        return location.getCreaturesOnLocation().stream()
                .filter(deers -> deers instanceof Deer)
                .toList().size();
    }
    public int getNumberOfDucks(){
        return location.getCreaturesOnLocation().stream()
                .filter(ducks -> ducks instanceof Duck)
                .toList().size();
    }
    public int getNumberOfGoats(){
        return location.getCreaturesOnLocation().stream()
                .filter(goats -> goats instanceof Goat)
                .toList().size();
    }
    public int getNumberOfHorses(){
        return location.getCreaturesOnLocation().stream()
                .filter(horses -> horses instanceof Horse)
                .toList().size();
    }
    public int getNumberOfMouses(){
        return location.getCreaturesOnLocation().stream()
                .filter(mouses -> mouses instanceof Mouse)
                .toList().size();
    }
    public int getNumberOfRabbits(){
        return location.getCreaturesOnLocation().stream()
                .filter(rabbits -> rabbits instanceof Rabbit)
                .toList().size();
    }
    public int getNumberOfSheeps(){
        return location.getCreaturesOnLocation().stream()
                .filter(sheeps -> sheeps instanceof Sheep)
                .toList().size();
    }
    public int getNumberOfBears(){
        return location.getCreaturesOnLocation().stream()
                .filter(bears -> bears instanceof Bear)
                .toList().size();
    }
    public int getNumberOfBoas(){
        return location.getCreaturesOnLocation().stream()
                .filter(boas -> boas instanceof Boa)
                .toList().size();
    }
    public int getNumberOfEagles(){
        return location.getCreaturesOnLocation().stream()
                .filter(eagles -> eagles instanceof Eagle)
                .toList().size();
    }
    public int getNumberOfFoxes(){
        return location.getCreaturesOnLocation().stream()
                .filter(foxes -> foxes instanceof Fox)
                .toList().size();
    }
    public int getNumberOfWolfs(){
        return location.getCreaturesOnLocation().stream()
                .filter(wolfs -> wolfs instanceof Wolf)
                .toList().size();
    }
    public int getNumberOfPlants(){
        return location.getCreaturesOnLocation().stream()
                .filter(plants -> plants instanceof Plant)
                .toList().size();
    }

    public void getStatistic() {
        int numberOfBoars = getNumberOfBoars();
        int numberOfBuffaloes = getNumberOfBuffaloes();
        int numberOfCaterpillars = getNumberOfCaterpillars();
        int numberOfDeers = getNumberOfDeers();
        int numberOfDucks = getNumberOfDucks();
        int numberOfGoats = getNumberOfGoats();
        int numberOfHorses = getNumberOfHorses();
        int numberOfMouses = getNumberOfMouses();
        int numberOfRabbits = getNumberOfRabbits();
        int numberOfSeeps = getNumberOfSheeps();
        int numberOfBears = getNumberOfBears();
        int numberOfBoas = getNumberOfBoas();
        int numberOfEagles = getNumberOfEagles();
        int numberOfFoxes = getNumberOfFoxes();
        int numberOfWolfs = getNumberOfWolfs();
        int numberOfPlants = getNumberOfPlants();

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
