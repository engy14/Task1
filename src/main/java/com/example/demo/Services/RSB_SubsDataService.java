package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.RSB_SubsData;
import com.example.demo.Reposatries.RSB_SubsDataRrpo;

@Service
public class RSB_SubsDataService {
	
	@Autowired
	private RSB_SubsDataRrpo subDatarepo;
	
	
	public List<RSB_SubsData> GetByTel(String tel) {

//		return subDatarepo.findByTelNum(tel).get(0).getSubName();
		return subDatarepo.findByTelNum(tel);


			
	}
	
//	public String GetByTel(String tel) {
//	Optional<RSB_SubsData> sub= subDatarepo.findById(tel);
//	RSB_SubsData sub1= sub.map(null)
//	return sub.g
//}

}
