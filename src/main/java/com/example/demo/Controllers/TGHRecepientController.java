package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.TGHRecepientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Recepient")
@Api(value="TGH Recepient Resource",description="Shows the Recepient Info")
public class TGHRecepientController {
	
    @Autowired
    private TGHRecepientService recepientService;
    
	@ApiOperation(value="Get Recepient Id")
	@GetMapping("/GetRecId")
	public Long GetNextId(){
		return recepientService.GetNextId();
	}


}
