package com.example.demo.Reposatries;
import com.example.demo.Models.TGHTemplateType;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TGHTemplateTypeRepo extends JpaRepository<TGHTemplateType,String>{
	

}
