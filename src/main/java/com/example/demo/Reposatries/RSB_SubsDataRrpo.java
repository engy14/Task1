package com.example.demo.Reposatries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.RSB_SubsData;

public interface RSB_SubsDataRrpo extends JpaRepository<RSB_SubsData,Long>{
	
	 List<RSB_SubsData> findByTelNum(String TelNum);

}
