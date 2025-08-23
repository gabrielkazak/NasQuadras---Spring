package com.nasquadras.NasQuadras.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {

    @Autowired
    private ITeamRepository teamRepository;

    @GetMapping("/teams")
    public List<TeamModel> getTeams(){
        return this.teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    public TeamModel getYourTeam(@PathVariable int id){
        return this.teamRepository.findByTeamId(id);
    }

    @GetMapping("/teams/search")
    public TeamModel getYourTeam(@RequestParam String name){
        return this.teamRepository.findByNameContainingIgnoreCase(name);
    }
}
