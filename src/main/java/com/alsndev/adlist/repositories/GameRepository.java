package com.alsndev.adlist.repositories;

import com.alsndev.adlist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
