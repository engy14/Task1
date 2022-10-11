package com.example.demo.Reposatries;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.Models.TGHGenerator;
import com.example.demo.Models.TGHTelegraph;

public interface TGHGeneratorRepo extends JpaRepository<TGHGenerator , Long>,JpaSpecificationExecutor<TGHGenerator>{
	
//	 @EntityGraph(value="generator-entity-graph")
//	 Page<TGHGenerator> findAll(int offset,int pagesize,String field);
	 
	 @Query( value = "SELECT TGH_GENERATOR_SEQ1.nextval from dual",nativeQuery = true)
	 Long GetNextId();

	
}
