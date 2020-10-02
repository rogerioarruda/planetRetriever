package com.starwars.planet_retriever.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starwars.planet_retriever.models.Planet;
import com.starwars.planet_retriever.repositories.PlanetRepository;

@Controller
@RequestMapping(path="/planet_retriever")
public class PlanetController {
  @Autowired
  private PlanetRepository planetRepository;

  @PostMapping(path="/add") 
  public @ResponseBody String addNewPlanet (@RequestParam String name,
		  @RequestParam String climate, 
		  @RequestParam String terrain) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Planet p = new Planet();
    p.setName(name);
    p.setClimate(climate);
    p.setTerrain(terrain);
    planetRepository.save(p);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Planet> getAllPlanets() {
    // This returns a JSON or XML with the users
    return planetRepository.findAll();
  }
}
