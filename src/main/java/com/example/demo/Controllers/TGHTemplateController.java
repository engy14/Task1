package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.TGHTemplate;
import com.example.demo.Services.TGHTemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Template")
@Api(value="TGH Template Resource",description="Shows the TGH Template Info")
public class TGHTemplateController {
	
	@Autowired
	private TGHTemplateService TemplateeSer;
	
    @ApiOperation(value="Search Telegraphs Templates by Template Code")
	@GetMapping("/getTemplatesTypes/{type}")
	public List<TGHTemplate> getallTemplatesTypes(@PathVariable String type){
		
		return TemplateeSer.getallTemplateByType(type);
		
	}
	
    
    

}
