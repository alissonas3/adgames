package com.alsndev.adlist.services;

import com.alsndev.adlist.dto.GameListDTO;
import com.alsndev.adlist.entities.GameList;
import com.alsndev.adlist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;      //Instancia de GameListRepository, injetando a instancia dentro do GameListService.

    @Transactional(readOnly = true)
    public List<GameListDTO> searchAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
