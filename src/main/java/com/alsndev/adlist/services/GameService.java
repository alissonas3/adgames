package com.alsndev.adlist.services;

import com.alsndev.adlist.dto.GameDTO;
import com.alsndev.adlist.dto.GameMinDTO;
import com.alsndev.adlist.entities.Game;
import com.alsndev.adlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;      //Instancia de GameRepository, injetando a instancia dentro do GameService.

    @Transactional(readOnly = true)
    public GameDTO searchById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> searchAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
