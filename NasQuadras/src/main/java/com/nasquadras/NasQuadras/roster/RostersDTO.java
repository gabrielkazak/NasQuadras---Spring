package com.nasquadras.NasQuadras.roster;

import lombok.Data;

@Data
public class RostersDTO {
    private final long id;
    private final String rosterName;

    public RostersDTO(long id, String rosterName) {
        this.id = id;
        this.rosterName = rosterName;
    }

}
