package com.backend.gamerservice.api.controller;

import com.backend.gamerservice.api.entity.GamerDetails;
import com.backend.gamerservice.api.entity.GamerDetailsDTO;
import com.backend.gamerservice.api.service.GamerService;
import com.backend.gamerservice.exceptionhandler.GameNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamer")
public class GamerController {

   private final GamerService gamerService;

    public GamerController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @PostMapping ("/update")
    public ResponseEntity<?> updateGamer(@Valid @RequestBody GamerDetailsDTO gamerDetails) throws GameNotFoundException {
        gamerService.saveGamer(gamerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/search")
    public List<GamerDetails> searchGamer(@RequestParam String level, @RequestParam String game, @RequestParam String geography)
    {
        return  gamerService.searchGamer(game,geography,level);
    }

    @GetMapping("/search/{game}")
    public List<GamerDetails> searchGamerByGame(@RequestParam String level, @PathVariable String game)
    {
        return  gamerService.searchGamerByGame(game,level);
    }


}
