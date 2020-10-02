package com.starwars.planet_retriever.repositories;

import org.springframework.data.repository.CrudRepository;

import com.starwars.planet_retriever.models.Planet;

public interface PlanetRepository extends CrudRepository<Planet, Long> {

}