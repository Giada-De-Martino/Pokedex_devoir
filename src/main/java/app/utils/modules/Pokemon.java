package app.utils.modules;

import java.util.List;

public class Pokemon {
    private String pokemonName;
    private PokemonType type;
    private int lifePoints;
    private List<Power> powers;

    public Pokemon() {}

    public Pokemon(String pokemonName, PokemonType type, int lifePoints, List<Power> powers) {
        this.pokemonName = pokemonName;
        this.type = type;
        this.lifePoints = lifePoints;
        this.powers = powers;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public void addPowers(Power p){
        this.powers.add(p);
    }

    public boolean validate() {
        return pokemonName != null && type != null && powers != null;
    }

//    @Override
//    public String toString() {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            return mapper.writeValueAsString(this);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return "{}";
//        }
//    }
}
