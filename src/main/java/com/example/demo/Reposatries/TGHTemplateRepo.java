package com.example.demo.Reposatries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Models.TGHTemplate;

public interface TGHTemplateRepo extends JpaRepository<TGHTemplate , String>{
	
	@Query(value="Select * from TGH_TEMPLATE where TEMP_TYPE_CODE=:TempTypeCode",nativeQuery=true)
	List<TGHTemplate> findByTempTypeCode(String TempTypeCode);

}
