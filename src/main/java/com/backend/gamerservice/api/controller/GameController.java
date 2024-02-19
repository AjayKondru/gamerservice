package com.backend.gamerservice.api.controller;

import com.backend.gamerservice.api.entity.GameDetails;
import com.backend.gamerservice.api.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/getList")
    public List<String> fetchGames()
    {
      return  gameRepository.findAll().stream().map(GameDetails::getName).toList();
    }

}
