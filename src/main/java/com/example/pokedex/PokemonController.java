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

        // Reset database
        Iterable<Pokemon> pokemonIterable = pokemonRepository.findAll();
        pokemonRepository.deleteAll(pokemonIterable);

        // Populate database
        pokemonRepository.saveAll(List.of(
                new Pokemon(0L, "Pikachu","Lightning"),
                new Pokemon(1L,"Pikachara","Lightning"),
                new Pokemon(2L,"Charmander","Fire"),
                new Pokemon(3L,"Bulbasaur","Grass"))
        );
    }

    @GetMapping("/pokemon/all")
    public Iterable<Pokemon> getAllPokemons(){
        return pokemonRepository.findAll();
    }

    @GetMapping("/pokemon/id/{id}")
    public Optional<Pokemon> getPokemonById(@PathVariable Long id){
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);

        if(pokemonOptional.isEmpty()){
            // handle this case later
        }

        return pokemonOptional;
    }

    @GetMapping("pokemon/{name}")
    public Iterable<Pokemon> getPokemonByName(@PathVariable String name){
        return pokemonRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("pokemon/nature/{nature}")
    public Iterable<Pokemon> getPokemonByNature(@PathVariable String nature){
        return pokemonRepository.findByNature(nature);
    }
}
