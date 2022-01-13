package com.javamaster.gamestore.service;


import com.javamaster.gamestore.dto.GamesDto;
import com.javamaster.gamestore.entity.Games;
import org.springframework.stereotype.Component;

@Component
public class GamesConverter {
    public Games fromGameDtoToGame(GamesDto gamesDto) {
        Games games = new Games();
        games.setId(gamesDto.getId());
        games.setName(gamesDto.getName());
        games.setPrice(gamesDto.getPrice());
        games.setDescription(gamesDto.getDescription());
        games.setReleaseDate(gamesDto.getReleaseDate());
        games.setRating(gamesDto.getRating());
        games.setPicture(gamesDto.getPicture());
        return games;
    }

    public GamesDto fromGameToGameDto(Games games) {
        GamesDto gamesDto = new GamesDto();
        gamesDto.setId(games.getId());
        gamesDto.setName(games.getName());
        gamesDto.setPrice(games.getPrice());
        gamesDto.setDescription(games.getDescription());
        gamesDto.setReleaseDate(games.getReleaseDate());
        gamesDto.setRating(games.getRating());
        gamesDto.setPicture(games.getPicture());
        return gamesDto;
    }
}
