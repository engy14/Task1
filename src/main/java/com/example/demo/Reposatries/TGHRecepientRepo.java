package com.example.demo.Reposatries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Models.TGHRecepient;

public interface TGHRecepientRepo extends JpaRepository<TGHRecepient,Long> {
	
	 @Query( value = "SELECT TGH_RECEPIENT_SEQ1.nextval from dual",nativeQuery = true)
	 Long GetNextId();

}
