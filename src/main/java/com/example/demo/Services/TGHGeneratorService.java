package com.example.demo.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.Models.TGHGenerator;
import com.example.demo.Models.TGHGeneratorSearch;
import com.example.demo.Models.TGHTelegraph;
import com.example.demo.Reposatries.TGHGeneratorRepo;
import com.example.demo.Reposatries.TGHGeneratorSpecification;

@Service
public class TGHGeneratorService {
	@Autowired
	private TGHGeneratorRepo TGHGeneratorrepo;


	public TGHGenerator SaveNewGenerator(TGHGenerator tghgenerator) {
		return TGHGeneratorrepo.save(tghgenerator);
	}
	
	public Long GetNextId() {
		return TGHGeneratorrepo.GetNextId();
	}
	

	public Page<TGHGenerator> FindAllGenerators(int offset,int pagesize,String field) {
		return TGHGeneratorrepo.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
	}
	
	
	public Page<TGHGenerator> Findbyattribute(TGHGeneratorSearch search,int offset,int pagesize) {
		TGHGeneratorSpecification spec=new TGHGeneratorSpecification(search);
		
		return TGHGeneratorrepo.findAll(spec, PageRequest.of(offset, pagesize));

	}
	

}
