package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.TGHRecepient;
import com.example.demo.Reposatries.TGHRecepientRepo;

@Service
public class TGHRecepientService {
	@Autowired
	private TGHRecepientRepo TGHRecepient_repo;
	
	public void insertRecepient(TGHRecepient recepient) {
		TGHRecepient_repo.save(recepient);
	}
	
	public Long GetNextId() {
		return TGHRecepient_repo.GetNextId();
	}

}
