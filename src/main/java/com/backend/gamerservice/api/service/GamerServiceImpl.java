package com.backend.gamerservice.api.service;

import com.backend.gamerservice.api.entity.GameDetails;
import com.backend.gamerservice.api.entity.GamerDetails;
import com.backend.gamerservice.api.entity.GamerDetailsDTO;
import com.backend.gamerservice.exceptionhandler.GameNotFoundException;
import com.backend.gamerservice.api.repository.GameRepository;
import com.backend.gamerservice.api.repository.GamerRepository;
import com.backend.gamerservice.exceptionhandler.GamerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamerServiceImpl implements GamerService{
    private final GamerRepository gamerRepository;
    private final GameRepository gameRepository;

    public GamerServiceImpl(GamerRepository gamerRepository, GameRepository gameRepository) {
        this.gamerRepository = gamerRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public void saveGamer(GamerDetailsDTO gamerDetails) throws GameNotFoundException {

        if((gameRepository.findByName(gamerDetails.game())).stream().map(GameDetails::getName)
                .toList().contains(gamerDetails.game()) ) {
            GamerDetails gd = GamerDetails.build(0,gamerDetails.name(),String.valueOf(gamerDetails.level()),gamerDetails.game(),gamerDetails.geography());
            gamerRepository.save(gd);
        }
        else
            throw new GameNotFoundException("Please Select game from List of Games available");
    }

    @Override
    public List<GamerDetails> searchGamer(String game, String geography, String level) {
        List<GamerDetails> gamers =     gamerRepository.searchGamer(game,geography,level);
        if(gamers.stream().count()==0) throw new GamerNotFoundException("No Gamers found for given criteria");
        return gamers;
    }

    @Override
    public List<GamerDetails> searchGamerByGame(String game, String level) {
        List<GamerDetails> gamers =  gamerRepository.findByGame(game).stream().filter(gamerDetails -> gamerDetails.getLevel().equalsIgnoreCase(level)).collect(Collectors.toList());
        if(gamers.stream().count()==0) throw new GamerNotFoundException("No Gamers found for given criteria");
        return gamers;
    }


}
