package com.example.demo.Reposatries;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Models.TGHTelegraph;

public interface TGHTelegraphRepo extends JpaRepository<TGHTelegraph , Long>,JpaSpecificationExecutor<TGHTelegraph>{
	
	@Query(value = "select * from TGH_TELEGRAPH where TGH_DATE between ? and ?",nativeQuery = true)
    public List<TGHTelegraph>getBetweenTwoDates(Date d1,Date d2);
	
	@Query(value = "select distinct NAME from SUBS_INFO",nativeQuery = true)
    public List<String> getUniqueValues();

}
