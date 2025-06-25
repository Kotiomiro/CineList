package com.cinelist.cinelist_api.infra;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cinelist.cinelist_api.domain.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.expiration-time-in-seconds}")
    private Long expirationTimeInSeconds;
    private Algorithm algorithm;

    @PostConstruct
    private void postConstruct() {
        algorithm = Algorithm.HMAC256(secret);
    }

    public String generateToken(User user) {
        try {
            var issuer = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
            var issuedAt = Instant.now();
            var expiresAt = issuedAt.plusSeconds(expirationTimeInSeconds);
            var roles = user
                    .getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();

            return JWT
                    .create()
                    .withIssuer(issuer)
                    .withSubject(user.getLogin())
                    .withIssuedAt(issuedAt)
                    .withExpiresAt(expiresAt)
                    .withClaim("roles", roles)
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public String validateToken(String token) {
        try {
            return JWT
                    .require(algorithm)
                    .withIssuer("cinelist-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

}
