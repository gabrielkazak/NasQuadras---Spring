package com.nasquadras.NasQuadras.users;

public record UserDTO(
        int id,
        String username,
        String email,
        String favTeam,
        String favoritePlayers
) {}
