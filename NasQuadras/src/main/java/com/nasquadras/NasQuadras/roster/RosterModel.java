package com.nasquadras.NasQuadras.roster;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Rosters")
public class RosterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rosterName;

    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String players;
}
