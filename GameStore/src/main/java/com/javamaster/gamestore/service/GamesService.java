package com.javamaster.gamestore.service;

import com.javamaster.gamestore.dto.GamesDto;

import java.util.List;

public interface GamesService {
    GamesDto saveGame(GamesDto gamesDto) throws com.javamaster.gamestore.exception.ValidationException;

    void deleteGame(Integer gameId);

    GamesDto findByName(String name);

    List<GamesDto> findAll();
}

