package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.TGHSenderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/Sender")
@Api(value="TGH Sender Resource",description="Shows the Sender Info")
public class TGHSenderController {
	
	@Autowired
	private TGHSenderService TGHSender_service;
	
//	 @PostMapping("/CreateTGHSender")
//	 TGHSender newTGHSender(@RequestBody TGHSender newTGHSender) {
//		 return TGHSender_service.insertSender(newTGHSender);
//	 }
	
	@ApiOperation(value="Get Sender Id")
	@GetMapping("/GetSenId")
	public Long GetNextSenId(){
		return TGHSender_service.GetNextId();
	}

}
