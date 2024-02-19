package com.backend.gamerservice.api.service;

import com.backend.gamerservice.api.entity.GamerDetails;
import com.backend.gamerservice.api.entity.GamerDetailsDTO;
import com.backend.gamerservice.exceptionhandler.GameNotFoundException;

import java.util.List;

public interface GamerService {

    void saveGamer(GamerDetailsDTO gamerDetails) throws GameNotFoundException;

    List<GamerDetails> searchGamer(String game, String geography, String level);

    List<GamerDetails> searchGamerByGame(String game, String level);
}
