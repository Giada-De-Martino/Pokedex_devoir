package app.utils.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pokedeck {
    private static List<Pokemon> pokemons;

    public Pokedeck(){
        this.pokemons = new ArrayList<Pokemon>();
    }

    public Pokedeck(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean containsName(String name){
        for (Pokemon p: pokemons){
            if(Objects.equals(p.getPokemonName(), name)) return true;
        }
        return false;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon p){
        this.pokemons.add(p);
    }

    public List<Pokemon> getAllByName(String name){
        List<Pokemon> result = new ArrayList<Pokemon>();
        for (Pokemon p: pokemons){
            if (p.getPokemonName().contains(name)) result.add(p);
        }
        return result;
    }

    public static boolean onlyLetters(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Pokemon> getAllByType(PokemonType type){
        List<Pokemon> result = new ArrayList<Pokemon>();
        for (Pokemon p: pokemons){
            if(p.getType() == type) result.add(p);
        }
        return result;
    }

    public static Pokemon getPokemonByName(String name){
        for (Pokemon p : pokemons){
            if (Objects.equals(p.getPokemonName(), name)) return p;
        }
        return null;
    }
}
