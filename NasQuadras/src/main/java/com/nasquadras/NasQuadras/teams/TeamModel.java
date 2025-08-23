package com.nasquadras.NasQuadras.teams;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "teams")
public class TeamModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    private String name;
    private String color1;
    private String color2;
    private String color3;
    private String logoUrl;

}
