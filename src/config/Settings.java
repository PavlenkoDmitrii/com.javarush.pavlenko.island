package config;

public class Settings {

    public static final int LINES = 3;
    public static final int COLUMNS = 3;

    public static final int NUMBER_OF_THREADS_FOR_SIMULATION = 1;
    public static final int NUMBER_OF_THREADS_FOR_WORKER = 4;

//WEIGHT
    public static final double WEIGHT_WOLF = 50;
    public static final double WEIGHT_BOA = 15;
    public static final double WEIGHT_FOX = 8;

    public static final double WEIGHT_BEAR = 500;
    public static final double WEIGHT_EAGLE = 6;
    public static final double WEIGHT_HORSE = 400;
    public static final double WEIGHT_DEER = 300;
    public static final double WEIGHT_RABBIT = 2;
    public static final double WEIGHT_MOUSE = 0.05;
    public static final double WEIGHT_GOAT = 60;
    public static final double WEIGHT_SHEEP = 70;
    public static final double WEIGHT_BOAR = 400;
    public static final double WEIGHT_BUFFALO = 700;
    public static final double WEIGHT_DUCK = 1;
    public static final double WEIGHT_CATERPILLAR = 0.01;
    public static final double WEIGHT_PLANT = 1;

//MAX_COUNT_ON_LOCATION
    public static final int MAX_COUNT_WOLF = 30;
    public static final int MAX_COUNT_BOA = 30;
    public static final int MAX_COUNT_FOX = 30;
    public static final int MAX_COUNT_BEAR = 5;
    public static final int MAX_COUNT_EAGLE = 20;
    public static final int MAX_COUNT_HORSE = 20;
    public static final int MAX_COUNT_DEER = 20;
    public static final int MAX_COUNT_RABBIT = 150;
    public static final int MAX_COUNT_MOUSE = 500;
    public static final int MAX_COUNT_GOAT = 140;
    public static final int MAX_COUNT_SHEEP = 140;
    public static final int MAX_COUNT_BOAR = 50;
    public static final int MAX_COUNT_BUFFALO = 10;
    public static final int MAX_COUNT_DUCK = 200;
    public static final int MAX_COUNT_CATERPILLAR = 1000;
    public static final int MAX_COUNT_PLANT = 200;

//MAX_SPEED
    public static final int MAX_SPEED_WOLF = 3;
    public static final int MAX_SPEED_BOA = 1;
    public static final int MAX_SPEED_FOX = 2;
    public static final int MAX_SPEED_BEAR = 2;
    public static final int MAX_SPEED_EAGLE = 3;
    public static final int MAX_SPEED_HORSE = 4;
    public static final int MAX_SPEED_DEER = 4;
    public static final int MAX_SPEED_RABBIT = 2;
    public static final int MAX_SPEED_MOUSE = 1;
    public static final int MAX_SPEED_GOAT = 3;
    public static final int MAX_SPEED_SHEEP = 3;
    public static final int MAX_SPEED_BOAR = 2;
    public static final int MAX_SPEED_BUFFALO = 3;
    public static final int MAX_SPEED_DUCK = 4;
    public static final int MAX_SPEED_CATERPILLAR = 0;

//MAX_SATIETY
    public static final double MAX_SATIETY_WOLF = 8;
    public static final double MAX_SATIETY_BOA = 3;
    public static final double MAX_SATIETY_FOX = 2;
    public static final double MAX_SATIETY_BEAR = 80;
    public static final double MAX_SATIETY_EAGLE = 1;
    public static final double MAX_SATIETY_HORSE = 60;
    public static final double MAX_SATIETY_DEER = 50;
    public static final double MAX_SATIETY_RABBIT = 0.45;
    public static final double MAX_SATIETY_MOUSE = 0.01;
    public static final double MAX_SATIETY_GOAT = 10;
    public static final double MAX_SATIETY_SHEEP = 15;
    public static final double MAX_SATIETY_BOAR = 50;
    public static final double MAX_SATIETY_BUFFALO = 100;
    public static final double MAX_SATIETY_DUCK = 0.15;
    public static final double MAX_SATIETY_CATERPILLAR = 0;

//NAMES
    public static final String WOLF_NAME = "Wolf";
    public static final String BOA_NAME = "Boa";
    public static final String FOX_NAME = "Fox";
    public static final String BEAR_NAME = "Bear";
    public static final String EAGLE_NAME = "Eagle";
    public static final String HORSE_NAME = "Horse";
    public static final String DEER_NAME = "Deer";
    public static final String RABBIT_NAME = "Rabbit";
    public static final String MOUSE_NAME = "Mouse";
    public static final String GOAT_NAME = "Goat";
    public static final String SHEEP_NAME = "Sheep";
    public static final String BOAR_NAME = "Boar";
    public static final String BUFFALO_NAME = "Buffalo";
    public static final String DUCK_NAME = "Duck";
    public static final String CATERPILLAR_NAME = "Caterpillar";
    public static final String PLANT_NAME = "Plant";

//PROBABILITY OF EAT IN %

    public static final int PROBABILITY_WOLF_EAT_HORSE = 10;
    public static final int PROBABILITY_WOLF_EAT_DEER = 15;
    public static final int PROBABILITY_WOLF_EAT_RABBIT = 60;
    public static final int PROBABILITY_WOLF_EAT_MOUSE = 80;
    public static final int PROBABILITY_WOLF_EAT_GOAT = 60;
    public static final int PROBABILITY_WOLF_EAT_SHEEP = 70;
    public static final int PROBABILITY_WOLF_EAT_BOAR = 15;
    public static final int PROBABILITY_WOLF_EAT_BUFFALO = 10;
    public static final int PROBABILITY_WOLF_EAT_DUCK = 40;

    public static final int PROBABILITY_BOA_EAT_FOX = 15;
    public static final int PROBABILITY_BOA_EAT_RABBIT = 20;
    public static final int PROBABILITY_BOA_EAT_MOUSE = 40;
    public static final int PROBABILITY_BOA_EAT_DUCK = 10;

    public static final int PROBABILITY_FOX_EAT_RABBIT = 70;
    public static final int PROBABILITY_FOX_EAT_MOUSE = 90;
    public static final int PROBABILITY_FOX_EAT_DUCK = 60;
    public static final int PROBABILITY_FOX_EAT_CATERPILLAR = 40;

    public static final int PROBABILITY_BEAR_EAT_BOA = 80;
    public static final int PROBABILITY_BEAR_EAT_HORSE = 40;
    public static final int PROBABILITY_BEAR_EAT_DEER = 80;
    public static final int PROBABILITY_BEAR_EAT_RABBIT = 80;
    public static final int PROBABILITY_BEAR_EAT_MOUSE = 90;
    public static final int PROBABILITY_BEAR_EAT_GOAT = 70;
    public static final int PROBABILITY_BEAR_EAT_SHEEP = 70;
    public static final int PROBABILITY_BEAR_EAT_BOAR = 50;
    public static final int PROBABILITY_BEAR_EAT_BUFFALO = 20;
    public static final int PROBABILITY_BEAR_EAT_DUCK = 10;

    public static final int PROBABILITY_EAGLE_EAT_FOX = 10;
    public static final int PROBABILITY_EAGLE_EAT_RABBIT = 90;
    public static final int PROBABILITY_EAGLE_EAT_MOUSE = 90;
    public static final int PROBABILITY_EAGLE_EAT_DUCK = 80;

    public static final int PROBABILITY_MOUSE_EAT_CATERPILLAR = 90;

    public static final int PROBABILITY_BOAR_EAT_MOUSE = 50;
    public static final int PROBABILITY_BOAR_EAT_CATERPILLAR = 90;

    public static final int PROBABILITY_DUCK_EAT_CATERPILLAR = 90;

    public static final int PROBABILITY_PLANTS_TO_BE_EATABLE = 100;

    public static final int FOOD_VALUE = 1;
}
