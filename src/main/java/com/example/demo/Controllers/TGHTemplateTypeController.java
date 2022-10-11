package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Models.TGHTemplateType;
import com.example.demo.Services.TGHTemplateTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/Templates")
@Api(value="TGH Template Type Resource",description="Shows the TGH Template Type Info")
public class TGHTemplateTypeController {
	
	@Autowired
	private TGHTemplateTypeService TemplateTypeSer;
	
    @ApiOperation(value="Returns all Telegraphs Templates Types")
	@GetMapping("/getTemplatesTypes")
	public List<TGHTemplateType> getallTemplatesTypes(){
		
		return TemplateTypeSer.getallTemplateTypes();
		
	}


}
