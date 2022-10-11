package com.example.demo.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.TGHSender;
import com.example.demo.Reposatries.TGHSenderRepo;

@Service
public class TGHSenderService {
	
	@Autowired
	private TGHSenderRepo TGHSender_repo;
	
	public void insertSender(TGHSender sender) {
		 TGHSender_repo.save(sender);
	}
	
	public Long GetNextId() {
		return TGHSender_repo.GetNextId();
	}

}
