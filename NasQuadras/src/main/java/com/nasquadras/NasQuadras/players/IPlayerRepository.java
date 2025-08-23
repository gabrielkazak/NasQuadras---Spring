package com.nasquadras.NasQuadras.players;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPlayerRepository extends JpaRepository<PlayerModel, Long> {
    List<PlayerModel> findByTop100LessThanEqualOrderByTop100Asc(int rank);

    List<PlayerModel> findByTeamContainingIgnoreCase(String team);

    List<PlayerModel> findByFullNameContainingIgnoreCase(String name);

    PlayerModel findByPersonIdNba(long personId_nba);
}
