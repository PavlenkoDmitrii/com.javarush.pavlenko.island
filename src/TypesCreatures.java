public enum TypesCreatures {
    //ID predators
    BEAR(1),
    BOA(2),
    EAGLE(3),
    FOX(4),
    WOLF(5),
    //ID herbivores
    BOAR(6),
    BUFFALO(7),
    CATERPILLAR(8),
    DEER(9),
    DUCK(10),
    GOAT(11),
    HORSE(12),
    MOUSE(13),
    RABBIT(14),
    SHEEP(15),
    //ID plant
    PLANT(0);

    private final int ID;

    TypesCreatures(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public static TypesCreatures getTypeCreaturesByID(int id) {
        TypesCreatures[] typesCreatures = TypesCreatures.values();
        TypesCreatures type = null;
        for (TypesCreatures typeCreature : typesCreatures) {
            if (id == typeCreature.ID) {
                type = typeCreature;
            }
        }
        return type;
    }

    public static TypesCreatures getPredatorByID(int id) {
        if (id > 0 && id < 6) {
            TypesCreatures[] typesCreatures = TypesCreatures.values();
            TypesCreatures type = null;
            for (TypesCreatures typeCreature : typesCreatures) {
                if (id == typeCreature.ID) {
                    type = typeCreature;
                }
            }
            return type;
        } else {
            throw new RuntimeException("Указан некорректный ID: " + id);
        }
    }

    public static TypesCreatures getHerbivoreByID(int id) {
        if (id > 5 && id < 16) {
            TypesCreatures[] typesCreatures = TypesCreatures.values();
            TypesCreatures type = null;
            for (TypesCreatures typeCreature : typesCreatures) {
                if (id == typeCreature.ID) {
                    type = typeCreature;
                }
            }
            return type;
        } else {
            throw new RuntimeException("Указан некорректный ID: " + id);
        }
    }
}
