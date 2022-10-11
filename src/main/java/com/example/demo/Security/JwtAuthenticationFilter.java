package com.example.demo.Security;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.Adminstration.TGHUserRepo;
import com.auth0.jwt.JWT;
import com.example.demo.Adminstration.LoginViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	
	private TGHUserRepo userRepo;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, TGHUserRepo userRepo) {
		this.authenticationManager = authenticationManager;
		this.userRepo = userRepo;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // Grab credentials and map them to login viewmodel
		System.out.println("authenticate");
        LoginViewModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());
        
        // Authenticate user
        Authentication auth = authenticationManager.authenticate(authenticationToken);

        return auth;              
        
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
    	// Grab principal
    	UserDetails principal = (UserDetails) authResult.getPrincipal();
    	
        // Grab user scopes
        List<String> scopes = userRepo.getScopes(principal.getUsername(), "REP_BUILDER_SCOPE");		
        
        String scopesConcat = "";
        for(int i = 0; i < scopes.size(); i++) {
        	if(i == scopes.size() - 1)
        		scopesConcat += scopes.get(i);
        	else
        		scopesConcat += scopes.get(i) + ';';		
        }

        
        Map<String, String> scopesPayload = new HashMap<>();
        scopesPayload.put("scopes", scopesConcat);
        
    	
    	// Create JWT Token
        String token = JWT.create()
                //.withSubject(principal.getUsername())
                //.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                //.sign(HMAC512(JwtProperties.SECRET.getBytes()));
        		.withSubject(principal.getUsername())
        		.withPayload(scopesPayload)
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));
       
        Map<String, String> tokenObj = new HashMap<>();
        tokenObj.put(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
        
        response.setContentType("application/json");
    	new ObjectMapper().writeValue(response.getOutputStream(), tokenObj);
	}
	
}		
