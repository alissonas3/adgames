package com.alsndev.adlist.services;

import com.alsndev.adlist.dto.GameListDTO;
import com.alsndev.adlist.entities.GameList;
import com.alsndev.adlist.projections.GameMinProjection;
import com.alsndev.adlist.repositories.GameListRepository;
import com.alsndev.adlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameListRepository gameListRepository;      //Instancia de GameListRepository, injetando a instancia dentro do GameListService.

    @Transactional(readOnly = true)
    public List<GameListDTO> searchAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection gameObj = list.remove(sourceIndex);
        list.add(destinationIndex, gameObj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
