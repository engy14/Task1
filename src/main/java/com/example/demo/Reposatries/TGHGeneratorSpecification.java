package com.example.demo.Reposatries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.Models.TGHGenerator;
import com.example.demo.Models.TGHGeneratorSearch;

public class TGHGeneratorSpecification implements Specification<TGHGenerator>{
	
	private TGHGeneratorSearch generatorSearch;
	
	

	public TGHGeneratorSpecification(TGHGeneratorSearch generatorSearch) {
		super();
		this.generatorSearch = generatorSearch;
	}

	public TGHGeneratorSearch getGeneratorSearch() {
		return generatorSearch;
	}

	public void setGeneratorSearch(TGHGeneratorSearch generatorSearch) {
		this.generatorSearch = generatorSearch;
	}

	@Override
	public Predicate toPredicate(Root<TGHGenerator> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		List<Predicate> predicates=new ArrayList<>();
		
		if(generatorSearch.getId()!=null) {
			predicates.add(cb.equal(root.get("id"), generatorSearch.getId())) ;
		}
		
		if(generatorSearch.getCallerName()!=null && !generatorSearch.getCallerName().isEmpty()) {
			predicates.add(cb.equal(root.get("callerName"), generatorSearch.getCallerName())) ;
		}
		
		if(generatorSearch.getCallerTelNum()!=null && !generatorSearch.getCallerTelNum().isEmpty()) {
			predicates.add(cb.equal(root.get("callerTelNum"), generatorSearch.getCallerTelNum())) ;
		}
		
		if(generatorSearch.getTemplate()==0 || generatorSearch.getTemplate()==1) {
			predicates.add(cb.equal(root.get("Template"), generatorSearch.getTemplate())) ;
		}
		
		if(generatorSearch.getTempTypeCode()!=null && !generatorSearch.getTempTypeCode().isEmpty()) {
			predicates.add(cb.equal(root.get("TempTypeCode"), generatorSearch.getTempTypeCode())) ;
		}
		
		if(generatorSearch.getTempCode()!=null && !generatorSearch.getTempCode().isEmpty()) {
			predicates.add(cb.equal(root.get("TempCode"), generatorSearch.getTempCode())) ;
		}
		
		if(generatorSearch.getDeliveryNotice()==0 || generatorSearch.getDeliveryNotice()==1) {
			predicates.add(cb.equal(root.get("DeliveryNotice"), generatorSearch.getDeliveryNotice())) ;
		}
		
		if(generatorSearch.getUrgent()==0 || generatorSearch.getUrgent()==1) {
			predicates.add(cb.equal(root.get("Urgent"), generatorSearch.getUrgent()));
		}
		
		if(generatorSearch.getSenddatefrom()!=null && generatorSearch.getSenddateto()!=null) {
			predicates.add(cb.between(root.get("SendDate"), generatorSearch.getSenddatefrom(), generatorSearch.getSenddateto())) ;
		}
		
		if(generatorSearch.getCalldatefrom()!=null && generatorSearch.getCalldateto()!=null) {
			predicates.add(cb.between(root.get("CallDate"), generatorSearch.getCalldatefrom(), generatorSearch.getCalldateto())) ;
		}
		
//		if(generatorSearch.getSendDate()!=null) {
//			predicates.add(cb.equal(root.get("SendDate"), generatorSearch.getSendDate())) ;
//		}
			
		return cb.and(predicates.toArray(new Predicate[0]));
	}

}
