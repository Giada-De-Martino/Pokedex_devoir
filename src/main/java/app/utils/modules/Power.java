package app.utils.modules;

public class Power {
    private String powerName;
    private PokemonType damageType;
    private int damage;

    public Power(){}

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public PokemonType getDamageType() {
        return damageType;
    }

    public void setDamageType(PokemonType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Power(String powerName, PokemonType damageType, int damage) {
        this.powerName = powerName;
        this.damageType = damageType;
        this.damage = damage;
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
