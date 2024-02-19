package com.backend.gamerservice.api.service;

import com.backend.gamerservice.api.entity.GameDetails;
import com.backend.gamerservice.api.entity.GamerDetails;
import com.backend.gamerservice.api.entity.GamerDetailsDTO;
import com.backend.gamerservice.api.entity.LEVEL;
import com.backend.gamerservice.api.repository.GameRepository;
import com.backend.gamerservice.api.repository.GamerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GamerServiceTests {
    @MockBean
    private GamerRepository gamerRepository;
    @MockBean
    private  GameRepository gameRepository;

    private final GamerServiceImpl gamerServiceImpl;
    @Autowired
    public GamerServiceTests(GamerServiceImpl gamerServiceImpl) {
        this.gamerServiceImpl = gamerServiceImpl;
    }
    @Test
    public void saveGamerTest()
    {
        GamerDetailsDTO gamerDTO = new GamerDetailsDTO("Gamer1", LEVEL.NOOB,"Football","Asia");
        GamerDetails gamer1 = GamerDetails.build(1,"Gamer1","Pro","Football","Asia");
        GameDetails gd1 = new GameDetails(1,"Football");
        GameDetails gd2 = new GameDetails(1,"Cricket");
        List<GameDetails> gamesList = new ArrayList<>();
        gamesList.add(gd1);
        gamesList.add(gd2);
        Mockito.when(gameRepository.findByName("Football")).thenReturn(gamesList);
        Mockito.when(gamerRepository.save(Mockito.any())).thenReturn(gamer1);
        gamerServiceImpl.saveGamer(gamerDTO);
    }

    @Test
    public void searchGamerTest()
    {
        GamerDetails gamer1 = GamerDetails.build(1,"Gamer1","Pro","Football","Asia");
        List<GamerDetails> gamerList = new ArrayList<>();
        gamerList.add(gamer1);

        Mockito.when( gamerRepository.searchGamer(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(gamerList);
        List<GamerDetails> searchList =   gamerServiceImpl.searchGamer("Football","Europe","Pro");
        assertThat(searchList).isNotNull();

    }


}
