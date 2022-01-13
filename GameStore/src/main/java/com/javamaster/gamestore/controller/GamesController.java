package com.javamaster.gamestore.controller;

import com.javamaster.gamestore.dto.GamesDto;
import com.javamaster.gamestore.exception.ValidationException;
import com.javamaster.gamestore.service.GamesService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@AllArgsConstructor
@Log
public class GamesController {
    private final GamesService gamesService;

    @PostMapping("/save")
    public GamesDto saveGames(@RequestBody GamesDto gamesDto) throws ValidationException {
        log.info("Сохраняю игру: " + gamesDto);
        return gamesService.saveGame(gamesDto);
    }

    @GetMapping("/findAll")
    public List<GamesDto> findAllGames() {
        log.info("Ищу все игры");
        return gamesService.findAll();
    }

    @GetMapping("/findByName")
    public GamesDto findByName(@RequestParam String name) {
        log.info("Ищу игру по названию: " + name);
        return gamesService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGames(@PathVariable Integer id) {
        log.info("Удаляю игру по id: " + id);
        gamesService.deleteGame(id);
        return ResponseEntity.ok().build();
    }
}
