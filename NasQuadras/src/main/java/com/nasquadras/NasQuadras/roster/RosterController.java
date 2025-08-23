package com.nasquadras.NasQuadras.roster;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class RosterController {

    @Autowired
    private IRosterRepository rosterRepository;

    @PostMapping("/roster")
    public ResponseEntity<RosterModel> createRoster(@RequestBody RosterModel roster){
        RosterModel savedRoster = this.rosterRepository.save(roster);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoster);
    }

    @GetMapping("/roster/{userId}")
    public List<RosterModel> retrieveRosters(@PathVariable int userId){
        return this.rosterRepository.findByUserId(userId);
    }

    @GetMapping("/roster/players/{rosterId}")
    public Optional<RosterModel> retrievePlayers(@PathVariable int rosterId){
        return this.rosterRepository.findById(rosterId);
    }

    @PutMapping("/roster/update/{id}")
    @Transactional
    public ResponseEntity<RosterModel> updateRoster(@PathVariable int id, @RequestBody RosterModel updatedRoster) {
        if (!rosterRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedRoster.setId((long) id);
        RosterModel saved = rosterRepository.save(updatedRoster);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/roster/delete/{id}")
    public ResponseEntity<Void> deleteRoster(@PathVariable int id){
        rosterRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
