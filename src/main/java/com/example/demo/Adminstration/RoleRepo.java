package com.example.demo.Adminstration;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
	
	Optional<Role> findById(Long id);
	
}