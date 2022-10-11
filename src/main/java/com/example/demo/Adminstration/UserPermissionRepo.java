package com.example.demo.Adminstration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPermissionRepo extends JpaRepository<UserPermission, UserPermissionId>{

	@Query(value="SELECT * FROM BPM_ADMINISTRATION.SC_USER_PERMISSION WHERE USER_ID = ?1 and MODULE_ID = ?2", nativeQuery = true)
	public List<UserPermission> getUserPermissionsById(Long USER_ID, Long MODULE_ID);
	
}
