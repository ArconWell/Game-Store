package com.javamaster.gamestore.repository;

import com.javamaster.gamestore.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Games, Integer>{
    Games findByName(String name);
}
