package com.nasquadras.NasQuadras.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private IPlayerRepository playerRepository;

    @GetMapping("/players/top")
    public List<PlayerModel> top100(){
        return this.playerRepository.findByTop100LessThanEqualOrderByTop100Asc(100);
    }

    @GetMapping("/players/team/{team}")
    public List<PlayerModel> playersByTeam(@PathVariable String team){
        return this.playerRepository.findByTeamContainingIgnoreCase(team);
    }

    @GetMapping("/players/search")
    public List<PlayerModel> playerByName(@RequestParam String name){
        return this.playerRepository.findByFullNameContainingIgnoreCase(name);
    }

    @GetMapping("/players/{personId_nba}")
    public ResponseEntity<PlayerModel> playerById(@PathVariable long personId_nba){
        PlayerModel player = this.playerRepository.findByPersonIdNba(personId_nba);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

}
