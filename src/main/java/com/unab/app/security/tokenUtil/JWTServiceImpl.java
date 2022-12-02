package com.unab.app.security.tokenUtil;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTServiceImpl implements IJWTService{
	
	public static final String SECRET=Base64Utils.encodeToString("4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud".getBytes()); 
	public static final long EXPIRACION_DATE= 2_592_000L; //tiempo vida util del token -> #dias*24horas*3600  (30dias)
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";
	
	@SuppressWarnings("deprecation")
	@Override
	public String create(Authentication auth) throws IOException {
		String username= ((User) auth.getPrincipal()).getUsername();
		
		Collection<? extends GrantedAuthority> roles=auth.getAuthorities();
		
		Claims claims= Jwts.claims();
		claims.put("authorities",  new ObjectMapper().writeValueAsString(roles));
		
		return Jwts.builder().setClaims(claims).setSubject(username)
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+EXPIRACION_DATE))
				.compact();
	}

	@Override
	public boolean validate(String token) {
		return false;
	}

	@Override
	public Claims getClaims(String token) {
		return null;
	}

	@Override
	public String getUsername(String token) {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {
		return null;
	}

	@Override
	public String resolve(String token) {
		return null;
	}

}
