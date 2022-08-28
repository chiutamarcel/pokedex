package com.example.pokedex;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    Iterable<Pokemon> findByNameContainingIgnoreCase(String name);

    Iterable<Pokemon> findByNature(String nature);
}
