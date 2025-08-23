package com.nasquadras.NasQuadras.players;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "player")
public class PlayerModel {

    @Id
    @JsonProperty("personId_nba")
    @Column(name = "personId_nba")
    private long personIdNba;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("team")
    private String team;

    @JsonProperty("team_id")
    private long team_id;

    @JsonProperty("headshot_url")
    private String headshot_url;

    @JsonProperty("top_100")
    @Column(name = "top_100")
    private Integer top100;
}
