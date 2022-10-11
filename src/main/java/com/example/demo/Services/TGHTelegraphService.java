package com.example.demo.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Models.TGHTelegraph;
import com.example.demo.Models.TGHTelegraphSearch;
import com.example.demo.Models.TGHGenerator;
import com.example.demo.Models.TGHGeneratorSearch;
import com.example.demo.Models.TGHSender;
import com.example.demo.Reposatries.TGHGeneratorSpecification;
import com.example.demo.Reposatries.TGHTelegraphRepo;
import com.example.demo.Reposatries.TGHTelegraphSpecification;



@Service
public class TGHTelegraphService {
	
	@Autowired
	private TGHTelegraphRepo telegraphRepo;
	
	public Page<TGHTelegraph> FindTelegByAttribute(TGHTelegraphSearch search,int offset,int pagesize) {
		TGHTelegraphSpecification spec=new TGHTelegraphSpecification(search);

		return telegraphRepo.findAll(spec,PageRequest.of(offset, pagesize));
	}
	
	public void insertTelegraph(TGHTelegraph telegraph) {
		telegraphRepo.save(telegraph);
	}
	
	public Page<TGHTelegraph> FindAllTelegraphs(int offset,int pagesize,String field){
		return telegraphRepo.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
	}
	
	public List<TGHTelegraph>getBetweenTwoDates(Date d1, Date d2)
	{
		return telegraphRepo.getBetweenTwoDates(d1,d2);
	}
	
	public List<String>getUniqueValues()
	{
		return telegraphRepo.getUniqueValues();
	}
	
//	public List<TGHTelegraph> Findbyattribute(TGHTelegraphSearch search) {
//		TGHTelegraphSpecification spec=new TGHTelegraphSpecification(search);
//		return telegraphRepo.findAll(spec);
//	}

}
