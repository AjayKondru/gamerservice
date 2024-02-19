package com.backend.gamerservice.api.repository;

import com.backend.gamerservice.api.entity.GameDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GameRepository extends JpaRepository<GameDetails,Integer> {

   List<GameDetails> findByName(String game);
}
