package com.javamaster.gamestore.service;

import com.javamaster.gamestore.dto.GamesDto;
import com.javamaster.gamestore.entity.Games;
import com.javamaster.gamestore.exception.ValidationException;
import com.javamaster.gamestore.repository.GamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class DefaultGamesService implements GamesService {

    private final GamesRepository gamesRepository;
    private final GamesConverter gamesConverter;

    private void validateGameDto(GamesDto gamesDto) throws ValidationException {
        if (isNull(gamesDto)) {
            throw new ValidationException("Object game is null");
        }
        if (isNull(gamesDto.getName()) || gamesDto.getName().isEmpty()) {
            throw new ValidationException("Name is empty");
        }
    }

    @Override
    public GamesDto saveGame(GamesDto usersDto) throws ValidationException {
        validateGameDto(usersDto);
        Games savedGame = gamesRepository.save(gamesConverter.fromGameDtoToGame(usersDto));
        return gamesConverter.fromGameToGameDto(savedGame);
    }

    @Override
    public void deleteGame(Integer gameId) {
        gamesRepository.deleteById(gameId);
    }

    @Override
    public GamesDto findByName(String name) {
        Games games = gamesRepository.findByName(name);
        if (games != null) {
            return gamesConverter.fromGameToGameDto(games);
        }
        return null;
    }

    @Override
    public List<GamesDto> findAll() {
        List<Games> gamesList = gamesRepository.findAll();
        List<GamesDto> gamesDtoList = new ArrayList<>();
        for (Games game : gamesList) {
            gamesDtoList.add(gamesConverter.fromGameToGameDto(game));
        }
        return gamesDtoList;
    }
}
