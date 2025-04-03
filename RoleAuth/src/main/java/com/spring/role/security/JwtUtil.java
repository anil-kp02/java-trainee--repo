package com.spring.role.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	 //requirement :
    public static final long JWT_TOKEN_VALIDITY = 60 *60*30;

    //    public static final long JWT_TOKEN_VALIDITY =  60;
    private String secretKey="afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf" ;//// Use environment variables in production
    
    
    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    
    public String generateToken(String userName) {
    	
    	Map<String,Object> claims = new HashMap<>();
    	
    	return Jwts.builder().addClaims(claims)
    			.setSubject(userName)
    			.setIssuedAt(new Date(System.currentTimeMillis()))
    			.setExpiration(new Date(System.currentTimeMillis() + 60 *60*1000))
    			.signWith(SignatureAlgorithm.HS512,secretKey)
    			.compact();
    	
    }
    
    public String extractUserName(String token) {
    	
    	
    	return  Jwts.parserBuilder()
                .setSigningKey(secretKey) // Set secret key
                .build()
                .parseClaimsJws(token) // Parse token
                .getBody()
                .getSubject();
    }
    
    public boolean validateToken(String token, UserDetails userDetails) {
    	String userName = extractUserName(token);
    	
    	return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    	
    }

	private boolean isTokenExpired(String token) {
		
		return Jwts.parserBuilder().setSigningKey(secretKey)
				.build().parseClaimsJws(token).getBody().getExpiration()
				.before(new Date());
	}
    
    
}
