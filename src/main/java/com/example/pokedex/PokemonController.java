package com.example.pokedex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PokemonController {

    private final PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;

        pokemonRepository.saveAll(List.of(
                new Pokemon(0L,"Pikachu","Lightning"),
                new Pokemon(1L,"Charmander","Fire"),
                new Pokemon(2L,"Bulbasaur","Grass"))
        );
    }

    @GetMapping("/pokemon")
    public Iterable<Pokemon> getAllPokemons(){
        return pokemonRepository.findAll();
    }

    @GetMapping("/pokemon/{id}")
    public Optional<Pokemon> getPokemon(@PathVariable Long id){
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);

        if(pokemonOptional.isEmpty()){
            // handle this case later
        }

        return pokemonOptional;
    }
}
