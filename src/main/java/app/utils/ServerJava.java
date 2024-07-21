package app.utils;

import app.utils.modules.ModifyPokemonRequest;
import app.utils.modules.Pokedeck;
import app.utils.modules.Pokemon;
import app.utils.modules.PokemonType;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class ServerJava {

    private final Javalin app;
    private final Logger logger = LoggerFactory.getLogger(ServerJava.class);
    private Pokedeck pokedeck = new Pokedeck();

    public ServerJava() {

        app = Javalin.create()
                .get("/api/status", ctx -> {
                    logger.debug("Status handler triggered", ctx);
                    ctx.status(200).result("Hello World");
                })

                .post("/api/create", ctx -> {
                    Pokemon pokemon = ctx.bodyAsClass(Pokemon.class);
                    if( pokemon.validate() && !pokedeck.containsName(pokemon.getPokemonName())){
                        ctx.status(200);
                        pokedeck.addPokemon(pokemon);
                        ctx.json(pokemon);
                    } else {
                        ctx.status(400);
                    }
                })

                .get("/api/searchByName", ctx -> {
                    String nameToSearch = ctx.queryParam("name");
                    if (Pokedeck.onlyLetters(nameToSearch)) {
                        ctx.json(pokedeck.getAllByName(nameToSearch));
                        ctx.status(200);
                    } else {
                        ctx.status(400);
                    }
                })

                .get("/api/searchByType", ctx -> {
                    String typeToSearch = ctx.queryParam("type");
                    if (PokemonType.exists(typeToSearch)) {
                        PokemonType type = PokemonType.valueOf(typeToSearch.toUpperCase());
                        ctx.json(Pokedeck.getAllByType(type));
                        ctx.status(200);
                    } else {
                        ctx.status(400);
                    }
                })

                .post("/api/modify", ctx -> {
                    ModifyPokemonRequest request = ctx.bodyAsClass(ModifyPokemonRequest.class);
                    Pokemon pokemon = Pokedeck.getPokemonByName(request.getPokemonName());
                    if(!request.validate()) {
                        ctx.status(400);
                    } else if (pokemon == null) {
                        ctx.status(404);
                    } else {
                        ctx.json(pokemon);
                        ctx.json(ModifyPokemonRequest.updatePokemon(pokemon));
                        ctx.status(200);
                    }
                })
        ;
    }

    public Javalin javalinApp() {
        return app;
    }
}
