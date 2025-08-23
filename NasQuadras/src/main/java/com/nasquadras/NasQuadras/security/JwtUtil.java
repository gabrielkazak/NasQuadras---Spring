package com.nasquadras.NasQuadras.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "hoje_eh_segunda_feira_ou_terca_nao_sei_mais!";
    private static final long EXPIRATION_MS = 1000 * 60 * 60 * 24;

    public static String generateToken(String username) {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(Keys.hmacShaKeyFor(keyBytes))
                .compact();
    }
}
