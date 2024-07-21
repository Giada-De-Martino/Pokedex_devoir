package app.utils.modules;

public enum PokemonType {
        NEUTRAL,
        FIRE,
        WATER,
        GRASS,
        ELECTRIC,
        ICE,
        FIGHTING,
        POISON,
        GROUND;

        public static boolean exists(String type) {
                for (PokemonType t : PokemonType.values()) {
                        if (t.name().equalsIgnoreCase(type)) {
                                return true;
                        }
                }
                return false;
        }
};

