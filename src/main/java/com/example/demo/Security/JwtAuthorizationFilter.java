package com.example.demo.Security;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.example.demo.Adminstration.Role;
import com.example.demo.Adminstration.RoleRepo;
import com.example.demo.Adminstration.TGHUser;
import com.example.demo.Adminstration.TGHUserRepo;
import com.example.demo.Adminstration.UserPermission;
import com.example.demo.Adminstration.UserPermissionRepo;
import com.example.demo.Adminstration.UserRole;
import com.example.demo.Adminstration.UserRoleRepo;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
	private TGHUserRepo userRepository;
	private RoleRepo roleRepository;
	private UserRoleRepo userRoleRepository;
	private UserPermissionRepo userPermissionRepo;
	private Long MODULE_ID;
	
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, TGHUserRepo userRepository,
			RoleRepo roleRepository, UserRoleRepo userRoleRepository, UserPermissionRepo userPermissionRepo,
			Long mODULE_ID) {
		super(authenticationManager);
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
		this.userPermissionRepo = userPermissionRepo;
		MODULE_ID = mODULE_ID;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {	
		
        // Read the Authorization header, where the JWT token should be
        String header = request.getHeader(JwtProperties.HEADER_STRING);
        
     // If header does not contain BEARER or is null delegate to Spring impl and exit
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
		
        // If header is present, try grab user principal from database and perform authorization
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continue filter execution
        chain.doFilter(request, response);
        

	}
	
	
	
	
	
	
	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKEN_PREFIX,"");

        if (token != null) {
            // parse the token and validate it
            String userName = JWT.require(HMAC512(JwtProperties.SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            // Search in the DB if we find the user by token subject (username)
            // If so, then grab user details and create spring auth token using username, pass, authorities/roles
            if (userName != null) {
                TGHUser user = userRepository.findByUsername(userName);
                
                if(user != null) {
                	// get user roles and permissions 
                	// then load them in the object user
                	List<UserRole> userRoles = userRoleRepository.getUserRolesById(user.getUserId());
                	List<Role> roles = new ArrayList<Role>();
                	userRoles.forEach(r -> {
                		roles.add(roleRepository.getById(r.getROLE_ID()));
                	});
                	user.setRoles(roles);
                	
                	List<UserPermission> userPermissions = userPermissionRepo.getUserPermissionsById(user.getUserId(), MODULE_ID);
                	user.setPermissions(userPermissions);
                	
                	UserPrinciple principal = new UserPrinciple(user);
                	UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
                	return auth;                	
                }
                else {
                	
                	user = new TGHUser();
                	
                	user.setUserName(userName);
                	user.setRoles(new ArrayList<>());
                	user.setPermissions(new ArrayList<>());
                	
                	UserPrinciple principal = new UserPrinciple(user);
                	
                	UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
                	return auth; 
                }
                
            }
            return null;
        }
        return null;
    }

}
