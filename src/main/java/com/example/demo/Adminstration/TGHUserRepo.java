package com.example.demo.Adminstration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TGHUserRepo extends JpaRepository<TGHUser, Long>{
	@Query(value = "SELECT * FROM BPM_ADMINISTRATION.SC_USERS WHERE lower(USER_NAME) = lower(?1)", nativeQuery = true)
	TGHUser findByUsername(String username);
	
	@Query(value = "SELECT VALUE FROM BPM_ADMINISTRATION.SC_USER_SCOPE WHERE lower(USER_NAME) = lower(?1) AND CODE = ?2", nativeQuery = true)
	List<String> getScopes(String username, String Code);

}
