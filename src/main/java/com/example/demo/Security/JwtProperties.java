package com.example.demo.Security;

public class JwtProperties {
	
	public static final String SECRET = "Secret";
	public static final int EXPIRATION_TIME = 8 * 60 * 60 * 1000; // 8 hours
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	
}
