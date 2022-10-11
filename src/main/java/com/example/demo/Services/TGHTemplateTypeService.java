package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Models.TGHTemplateType;
import com.example.demo.Reposatries.TGHTemplateTypeRepo;

@Service
public class TGHTemplateTypeService {

	@Autowired
	private  TGHTemplateTypeRepo TemplateTypeRepo;
	
	public List<TGHTemplateType> getallTemplateTypes(){
		return TemplateTypeRepo.findAll();
	}
}
