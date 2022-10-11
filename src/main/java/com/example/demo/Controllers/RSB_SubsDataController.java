package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.RSB_SubsData;
import com.example.demo.Services.RSB_SubsDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/SubData")
@Api(value="SubData Info Resource",description="Shows the SubData Info")
public class RSB_SubsDataController {
	
	@Autowired
	private RSB_SubsDataService subsDataService;
	
//    @ApiOperation(value="Get Name by TeleNum")
//	@GetMapping("/GetNameByTele/{Telephone}")
//	public String FindTelegByAttribute(@PathVariable String Telephone){		
//    	String res=" ";
//    	res=subsDataService.GetByTel(Telephone);
//		 System.out.println("************************************************************************************************************************");
//		 System.out.println(res);
//		 System.out.println("************************************************************************************************************************");
//    	if(res.isEmpty()) {
//    		 System.out.println("###");
//
//    	}
//    	else
//    	{    		 System.out.println("$$$$");}
//    	return res;
//
//	}
	
    @ApiOperation(value="Get Name by TeleNum")
	@GetMapping("/GetNameByTele/{Telephone}")
	public List<RSB_SubsData> FindTelegByAttribute(@PathVariable String Telephone){		
		List<RSB_SubsData> res;

//    	try{
//    		res=subsDataService.GetByTel(Telephone);
//    	}
//    	catch(Exception e){
//    		return res;
//    	}
    	
    	return subsDataService.GetByTel(Telephone);

	}

}
