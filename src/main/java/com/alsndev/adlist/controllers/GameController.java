package com.alsndev.adlist.controllers;

import com.alsndev.adlist.dto.GameDTO;
import com.alsndev.adlist.dto.GameMinDTO;
import com.alsndev.adlist.entities.Game;
import com.alsndev.adlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;            //Instancia de GameService. Controller injetando um Service.

    @GetMapping(value = "/{id}")
    public GameDTO searchById(@PathVariable Long id) {
        GameDTO result = gameService.searchById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> searchAll() {
        List<GameMinDTO> result = gameService.searchAll();
        return result;
    }

}
