package com.alsndev.adlist.services;

import com.alsndev.adlist.dto.GameMinDTO;
import com.alsndev.adlist.entities.Game;
import com.alsndev.adlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;      //Instancia de GameRepository, injetando a instancia dentro do GameService.

    public List<GameMinDTO> searchAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
