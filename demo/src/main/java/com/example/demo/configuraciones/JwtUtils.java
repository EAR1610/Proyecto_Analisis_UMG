package com.example.demo.configuraciones;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
* Clase que se encarga de generar y validar los tokens JWT (JSON Web Tokens) utilizados para autenticar y
* autorizar a los usuarios en la aplicación.
*
*   SECRET_KEY: Una cadena que se utiliza para firmar y verificar los tokens. En este caso, el valor es "proyectUMG".

    extractUsername(String token): Método que extrae el nombre de usuario del token.

    extractExpiration(String token): Método que extrae la fecha de expiración del token.

    extractClaim(String token, Function<Claims, T> claimsResolver): Método genérico que permite extraer cualquier información de los claims (datos) del token.

    extractAllClaims(String token): Método que devuelve todos los claims del token.

    isTokenExpired(String token): Método que verifica si el token ha expirado.

    generateToken(UserDetails userDetails): Método que genera un nuevo token JWT utilizando los detalles del usuario proporcionados.

    createToken(Map<String, Object> claims, String subject): Método que crea un nuevo token JWT utilizando los claims y el sujeto (nombre de usuario) proporcionados.

    validateToken(String token, UserDetails userDetails): Método que verifica si el token es válido para el usuario proporcionado, comprobando si el nombre de usuario es correcto y si el token no ha expirado.
* */
@Component
public class JwtUtils {
    private String SECRET_KEY = "proyectUMG";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
