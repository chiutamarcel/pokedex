# Pokedex

## Description

This is a dictionary of pokemons, with information about their name and nature.
I wrote this Rest API as a sample project for learning Spring

## Running the application

### Warning: you need PostgreSQL installed and the pokedex database created in order to run this project!

This is an IntelliJ project, so it needs to be opened using the IDE and executed like any other project.
The entry point is PokedexApplication.

## Usage

- GET /pokemon for listing of all the existing pokemons
- GET /pokemon/{id} for searching a pokemon by its id

## Future functionalities

- GET /pokemon/{name} for searching a pokemon by name
- GET /pokemon/{nature} for listing all pokemons of a certain nature

## Known bugs

- GET /pokemon/{id} returns a blank page if the pokemon with that id doesn't exist
