package com.alsndev.adlist.controllers;

import com.alsndev.adlist.dto.GameListDTO;
import com.alsndev.adlist.dto.GameMinDTO;
import com.alsndev.adlist.services.GameListService;
import com.alsndev.adlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;            //Instancia de GameListService. Controller injetando um Service.

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> searchAll() {
        List<GameListDTO> result = gameListService.searchAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> searchByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.searchByList(listId);
        return result;
    }

}
