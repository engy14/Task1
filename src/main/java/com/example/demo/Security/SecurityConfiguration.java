package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Adminstration.Role;
import com.example.demo.Adminstration.RoleRepo;
import com.example.demo.Adminstration.TGHUserRepo;
import com.example.demo.Adminstration.UserPermission;
import com.example.demo.Adminstration.UserPermissionRepo;
import com.example.demo.Adminstration.UserRole;
import com.example.demo.Adminstration.UserRoleRepo;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    private TGHUserRepo userRepository;
	private UserDetailsServiceImpl userPrincipalDetailsService;
	private RoleRepo roleRepository;
	private UserRoleRepo userRoleRepository;
	private UserPermissionRepo userPermissionRepo;
//	private WLSAuthenticationProvider wlsAuthenticationProvider;
	
	@Value("${module.id}")
	private Long MODULE_ID;
	
	@Value("${LDAP.url}")
	private String LDAP_URL;
	
	@Value("${LDAP.managerDN}")
	private String LDAP_managerUser;
	
	@Value("${LDAP.managerPassword}")
	private String LDAP_managerPassword;
	
	@Value("${LDAP.userFilter}")
	private String LDAP_userFilter;
	
	@Value("${LDAP.groupFilter}")
	private String LDAP_groupFilter;
	
    public SecurityConfiguration(UserDetailsServiceImpl userPrincipalDetailsService, TGHUserRepo userRepository,
			RoleRepo roleRepository, UserRoleRepo userRoleRepository, UserPermissionRepo userPermissionRepo
//			, WLSAuthenticationProvider wlsAuthenticationProvider
			) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
		this.userPermissionRepo = userPermissionRepo;
//		this.wlsAuthenticationProvider = wlsAuthenticationProvider;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
    	http
        .cors().disable()
        //.and()
		// remove csrf and state in session because in jwt we do not need them
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        // add jwt filters (1. authentication, 2. authorization)
        .addFilter(new JwtAuthenticationFilter(authenticationManager(), userRepository))
    	.addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepository, this.roleRepository, this.userRoleRepository, this.userPermissionRepo, MODULE_ID))
        .authorizeRequests()
        // configure access rules
        .antMatchers(HttpMethod.POST, "/login").permitAll()          

        .antMatchers(HttpMethod.GET,"/swagger-ui.html").permitAll()
        .antMatchers(HttpMethod.GET,"/swagger-ui.html").permitAll()
        .antMatchers(HttpMethod.GET,"/v2/api-docs/**").permitAll()
        .antMatchers(HttpMethod.GET,"/swagger.json").permitAll()
        .antMatchers(HttpMethod.GET,"/swagger-resources/**").permitAll()
        .antMatchers(HttpMethod.GET,"/webjars/**").permitAll()
        .antMatchers(HttpMethod.GET,"/swagger-ui/**").permitAll()
        //.antMatchers("/schedulejob/getjobs").hasRole("CC Online Support")
        //.antMatchers("/freqlookup/get").hasRole("CC Online Support")
        //.antMatchers("/*").hasRole("CC Online Support")
        //.antMatchers("/schedulejob/getjobs").hasAuthority("Draft.Pull")
        //.antMatchers("/api/public/admin/*").hasRole("ADMIN")
        .anyRequest().authenticated();
    	
    	http.cors();
  

}

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEnconder();
        }
}
	