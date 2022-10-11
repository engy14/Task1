package com.example.demo.Reposatries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Models.TGHSender;

public interface TGHSenderRepo extends JpaRepository<TGHSender,Long>{
	
	 @Query( value = "SELECT TGH_SENDER_SEQ.nextval from dual",nativeQuery = true)
	 Long GetNextId();
	 

}
