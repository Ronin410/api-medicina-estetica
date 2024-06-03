/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author alejandro.bueno
 */

public class JwtUtil {

    private static final String SECRET_KEY = "MedicinaEstetica"; // Reemplazar por una clave segura

    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        try{
        
        
        claims.put("username", username);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        }catch(Exception ex){
            return "";
        }
    }
    
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static String extractUsername(String token) {
        return (String) extractClaim(token, Claims::getSubject);
    }

    public static String extractRole(String token) {
        return (String) extractClaim(token, claim -> claim.get("role"));
    }

    private static Object extractClaim(String token, Function<Claims, Object> claimResolver) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claimResolver.apply(claims);
    }
}