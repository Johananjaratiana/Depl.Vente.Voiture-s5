package com.vente.voiture.ws.security.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.vente.voiture.ws.security.user.ProfilUtilisateur;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;


@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(int userId) throws Exception {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expiration);

        String token = Jwts.builder()
                .setSubject(Integer.toString(userId))
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        try{
            Token.saveToken(userId, token, expirationDate);
            return token;
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public void validateToken(String authorizationHeader) throws Exception {
        try {
            String token = this.GetRealToken(authorizationHeader);
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            // Vérifier si le token est présent dans la base de données et n'a pas expiré
            if(Token.isTokenValid(token)){}
            else throw new Exception("S`il vous plaît reconnectez vous");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public ProfilUtilisateur validateTokenReturningProfilUtilisateur(String authorizationHeader) throws Exception {
        try {
            String token = this.GetRealToken(authorizationHeader);
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            // Vérifier si le token est présent dans la base de données et n'a pas expiré
            if(Token.isTokenValid(token))return ProfilUtilisateur.GetProfilUtilisateurByUserId(Integer.parseInt(getUserIdFromToken(token)));
            else throw new Exception("S`il vous plaît reconnectez vous");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public Users validateTokenReturningUsers(UsersService usersService, String authorizationHeader) throws Exception {
        try {
            String token = this.GetRealToken(authorizationHeader);
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            // Vérifier si le token est présent dans la base de données et n'a pas expiré
            if(Token.isTokenValid(token))return usersService.getUsersById(Long.parseLong(getUserIdFromToken(token))).get();
            else throw new Exception("S`il vous plaît reconnectez vous");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public String GetRealToken(String authorizationHeader) throws Exception{
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                return authorizationHeader.substring(7); // Extract the token excluding "Bearer "
            } else {
                throw new Exception("Erreur d` authentification (nekot)");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }
}

