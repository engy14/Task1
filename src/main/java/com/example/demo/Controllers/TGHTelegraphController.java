package com.example.demo.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.TGHGenerator;
import com.example.demo.Models.TGHTelegraph;
import com.example.demo.Models.TGHTelegraphSearch;
import com.example.demo.Models.TGHTemplate;
import com.example.demo.Services.TGHTelegraphService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Telegraphs")
@Api(value="TGH Telegraphs Resource",description="Shows the TGH Telegraphs Info")
public class TGHTelegraphController {
	
	@Autowired
	private TGHTelegraphService TGHTelpser;

    @ApiOperation(value="Search Telegraphs")
	@PostMapping("/FindTelegByAttribute/{offset}/{pagesize}")
	public Page<TGHTelegraph> FindTelegByAttribute(@RequestBody TGHTelegraphSearch ser,@PathVariable int offset,@PathVariable int pagesize){
//		 System.out.println("********************************************************************************************************************");
//    	System.out.println(ser.getCallerName());
			return TGHTelpser.FindTelegByAttribute(ser,offset,pagesize);		
	}
    
    @ApiOperation(value="Returns All Telegraphs in pages") 
	@GetMapping("/alltele/{offset}/{pagesize}/{field}")
	public Page<TGHTelegraph> getalltelegraphs(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
		return TGHTelpser.FindAllTelegraphs(offset,pagesize,field);
	}
    
//    @ApiOperation(value="Search between two dates") 
//	@GetMapping("/getbetweenDates/{date1}/{date2}")
//	public List<TGHTelegraph>getBetweenTwoDates(@PathVariable  String date1, @PathVariable  String date2)throws Exception
//	{
// 		Date d1=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
//		Date d2=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
//		return  TGHTelpser.getBetweenTwoDates(d1,d2);
//	}
    

    @ApiOperation(value="Get Unique Values in Specific Attribute") 
	@GetMapping("/getUniqueValues")
	public List<String>getUniqueValues()throws Exception
	{

		return  TGHTelpser.getUniqueValues();
	}
}
