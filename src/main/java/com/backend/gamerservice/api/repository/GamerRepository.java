package com.backend.gamerservice.api.repository;

import com.backend.gamerservice.api.entity.GamerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamerRepository extends JpaRepository<GamerDetails,Integer> {
    @Query("SELECT p FROM GamerDetails p  WHERE p.game = :game  and p.level= :level and p.geography=:geography ")
    List<GamerDetails> searchGamer(String game, String geography, String level);

    List<GamerDetails> findByGame(String game);
}
