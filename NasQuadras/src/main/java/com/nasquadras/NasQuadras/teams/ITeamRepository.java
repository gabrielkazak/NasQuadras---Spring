package com.nasquadras.NasQuadras.teams;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<TeamModel, Integer>{
    TeamModel findByTeamId(int id);
    TeamModel findByNameContainingIgnoreCase(String name);
}
