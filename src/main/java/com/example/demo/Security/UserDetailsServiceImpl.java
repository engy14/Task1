package com.example.demo.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Adminstration.UserRole;
import com.example.demo.Adminstration.UserRoleRepo;


import com.example.demo.Adminstration.Role;
import com.example.demo.Adminstration.RoleRepo;
import com.example.demo.Adminstration.TGHUser;
import com.example.demo.Adminstration.TGHUserRepo;
import com.example.demo.Adminstration.UserPermission;
import com.example.demo.Adminstration.UserPermissionRepo;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private TGHUserRepo userRepository;
	private UserRoleRepo userroleRepository;
	private RoleRepo roleRepo;
	private UserPermissionRepo userPermissionRepo;
	
	@Value("${module.id}")
	private Long MODULE_ID;


	public UserDetailsServiceImpl(TGHUserRepo userRepository, UserRoleRepo userroleRepository, RoleRepo roleRepo,
			UserPermissionRepo userPermissionRepo) {
		super();
		this.userRepository = userRepository;
		this.userroleRepository = userroleRepository;
		this.roleRepo = roleRepo;
		this.userPermissionRepo = userPermissionRepo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		TGHUser user=userRepository.findByUsername(username);
		
		if(user == null) 
			throw new UsernameNotFoundException("User not found");
		
		// get user roles and permissions 
		// then load them in the object user
		List<UserRole> userRoles = userroleRepository.getUserRolesById(user.getUserId());
		List<Role> roles = new ArrayList<Role>();
		
		userRoles.forEach(r -> {
			roles.add(roleRepo.getById(r.getROLE_ID()));
		});
		
		user.setRoles(roles);
		
		List<UserPermission> userPermissions = userPermissionRepo.getUserPermissionsById(user.getUserId(), MODULE_ID);
		user.setPermissions(userPermissions);
		
		UserPrinciple userPrincipal = new UserPrinciple(user);

		
		return userPrincipal;
	}

	
}
