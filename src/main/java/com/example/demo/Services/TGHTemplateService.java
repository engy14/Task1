package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.TGHTemplate;
import com.example.demo.Reposatries.TGHTemplateRepo;


@Service
public class TGHTemplateService {

	@Autowired
	private TGHTemplateRepo TGHTemplaterepo;
	
	public List<TGHTemplate> getallTemplateByType(String type){
		return TGHTemplaterepo.findByTempTypeCode(type);
	}	

}
