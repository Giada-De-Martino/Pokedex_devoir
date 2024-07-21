package app.utils.modules;

import java.util.List;

public class ModifyPokemonRequest {
    private String pokemonName;
    private static PokemonType type;
    private static int lifePoints;
    private static List<Power> powers;

    public ModifyPokemonRequest() {}

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setPowers(List<Power> powers) {
        ModifyPokemonRequest.powers = powers;
    }

    public void setLifePoints(int lifePoints) {
        ModifyPokemonRequest.lifePoints = lifePoints;
    }

    public void setType(PokemonType type) {
        ModifyPokemonRequest.type = type;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public PokemonType getType() {
        return type;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public boolean validate() {
        return pokemonName != null;
    }

    public static Pokemon updatePokemon(Pokemon p){
        if( type != null ) p.setType(type);
        if( lifePoints != 0 ) p.setLifePoints(lifePoints);
        if(powers != null) {
            for (Power pow: powers){
                p.addPowers(pow);
            }
        }
        return p;
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
