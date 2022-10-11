package com.example.demo.Reposatries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.Models.TGHTelegraph;
import com.example.demo.Models.TGHTelegraphSearch;

public class TGHTelegraphSpecification  implements Specification<TGHTelegraph> {
	
//	@Autowired
	private TGHTelegraphSearch telegraphSearch;
	
		

	public TGHTelegraphSpecification(TGHTelegraphSearch telegraphSearch) {
		super();
		this.telegraphSearch = telegraphSearch;
	}

	public TGHTelegraphSearch getTelegraphSearch() {
		return telegraphSearch;
	}

	public void setTelegraphSearch(TGHTelegraphSearch telegraphSearch) {
		this.telegraphSearch = telegraphSearch;
	}

	@Override
	public Predicate toPredicate(Root<TGHTelegraph> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates=new ArrayList<>();
		
		if(telegraphSearch.getTGHId()!=null) {
			predicates.add(cb.equal(root.get("TGHId"), telegraphSearch.getTGHId())) ;
		}
		
		
		if(telegraphSearch.getGenId()!=null) {
			predicates.add(cb.equal(root.get("GenId"), telegraphSearch.getGenId())) ;
		}
		
		if(telegraphSearch.getSenderName()!=null && !telegraphSearch.getSenderName().isEmpty()) {
			predicates.add(cb.equal(root.get("SenderName"), telegraphSearch.getSenderName())) ;
		}
		
		if(telegraphSearch.getCallerName()!=null&& !telegraphSearch.getCallerName().isEmpty()) {
			predicates.add(cb.equal(root.get("CallerName"), telegraphSearch.getCallerName())) ;
		}
		
		if(telegraphSearch.getAddress()!=null&& !telegraphSearch.getAddress().isEmpty()) {
			predicates.add(cb.equal(root.get("Address"), telegraphSearch.getAddress())) ;
		}
		
		if(telegraphSearch.getNotes()!=null&& !telegraphSearch.getNotes().isEmpty()) {
			predicates.add(cb.equal(root.get("Notes"), telegraphSearch.getNotes())) ;
		}
		
		if(telegraphSearch.getStatusCode()!=null&& !telegraphSearch.getStatusCode().isEmpty()) {
			predicates.add(cb.equal(root.get("StatusCode"), telegraphSearch.getStatusCode())) ;
		}
		
		if(telegraphSearch.getCost()!=null&& !telegraphSearch.getCost().isEmpty()) {
			predicates.add(cb.equal(root.get("Cost"), telegraphSearch.getCost())) ;
		}
		
		if(telegraphSearch.getTghdate()!=null && telegraphSearch.getTghdateto()!=null) {
			predicates.add(cb.between(root.get("TGHDate"), telegraphSearch.getTghdate(), telegraphSearch.getTghdateto())) ;
		}
		
		if(telegraphSearch.getSenddatefrom()!=null && telegraphSearch.getSenddateto()!=null) {
			predicates.add(cb.between(root.get("TGHSend_Date"), telegraphSearch.getSenddatefrom(), telegraphSearch.getSenddateto())) ;
		}
		
		return cb.and(predicates.toArray(new Predicate[0]));

		
//		if(telegraphSearch.getTghdate()!=null) {
//			predicates.add(cb.equal(root.get("tghdate"), telegraphSearch.getTghdate())) ;
//			 date=1;
//		}
//		
//		if(telegraphSearch.getTghdateto()!=null) {
//			predicates.add(cb.equal(root.get("tghdateto"), telegraphSearch.getTghdateto())) ;
//		}
		
		
//		if(telegraphSearch.getTghdate()!=null) {
//			predicates.add(cb.equal(root.get("SendDate"), telegraphSearch.getTghdate())) ;
//		}
		
//		 System.out.println("****************************************");
//		 System.out.println(telegraphSearch.getTGH_Id());
//		 System.out.println("****************************************");
//		if(date==1) {
//			 cb.and(predicates.toArray(new Predicate[0]));
//			 cb.and(predicates.toArray(new Predicate[1]));
//			 return cb;
//
//
//		}
//		else {

	}
	
	

}
