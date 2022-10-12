package com.example.demo.Controllers;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Models.TGHSender;
import com.example.demo.Models.TGHTelegraph;
import com.example.demo.Models.TGHGenerator;
import com.example.demo.Models.TGHGeneratorSearch;
import com.example.demo.Models.TGHRecepient;
import com.example.demo.Services.TGHGeneratorService;
import com.example.demo.Services.TGHRecepientService;
import com.example.demo.Services.TGHSenderService;
import com.example.demo.Services.TGHTelegraphService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.example.demo.Services.RSB_SubsDataService;



@RestController
@RequestMapping("/Template")
@Api(value="TGH Generator Resource",description="Shows the Generator Info")
public class TGHGeneratorController {
		
	
    @Autowired
	private TGHGeneratorService  tghgeneratorserv;
	@Autowired
	private TGHSenderService TGHSender_service;
	@Autowired
	private TGHRecepientService TGHRecepient_service;
	@Autowired
	private TGHTelegraphService TGHRTelegraph_service;
	@Autowired
	private RSB_SubsDataService RSB_SubsDataservice;

	 @ApiOperation(value="Create New Telegraph")
	 @PostMapping("/CreateTGHGenerator")
	 TGHGenerator newTGHGenerator(@RequestBody TGHGenerator newTGHGenerator) {
		 Set<TGHSender>Senders=newTGHGenerator.getSenders();
		 Set<TGHRecepient>Recepients=newTGHGenerator.getReciepnts();
		 Set<TGHTelegraph>Telegraphs=newTGHGenerator.getTelegraphs() ;
		 
		 System.out.println("****************************************************************************************************************************************");
		 System.out.println(newTGHGenerator.getSendDate());
		 System.out.println("******************************************************************************************************************************");
		 

		 
		 String name=RSB_SubsDataservice.GetByTel(newTGHGenerator.getCallerTelNum()).get(0).getSubName();
		 newTGHGenerator.setCallerName(name);
	
		 
		 newTGHGenerator=tghgeneratorserv.SaveNewGenerator(newTGHGenerator);

		 
		 System.out.println(newTGHGenerator);

		 System.out.println(newTGHGenerator.getSenders());

		 for(TGHSender sender:Senders)
		 {    
//			 System.out.println("********************************************************************************************************************");
//			 System.out.println(sender.getSenderId());
//			 System.out.println("********************************************************************************************************************");
			 sender.setGenId(newTGHGenerator.getId());
			 sender.setSenderId(sender.getSenderId());
			 		 		 
			 sender.setGenerator1(newTGHGenerator);
			 
			 
			 		
			 TGHSender_service.insertSender(sender);
		 }		
		 
		 for(TGHRecepient recepient:Recepients)
		 {    recepient.setGenId(newTGHGenerator.getId());
		      recepient.setGenerator2(newTGHGenerator);	
		      recepient.setRecId(recepient.getRecId());
		      TGHRecepient_service.insertRecepient(recepient);
		 }
		 
//		 System.out.println("********************************************************************************************************************");
//		 System.out.println(newTGHGenerator.getsenders());


		 
		 TGHTelegraph tel=new TGHTelegraph();
		 for(TGHSender sender:Senders) {
			 for(TGHRecepient recepient:Recepients) {				 
				 tel.setGenerator3(newTGHGenerator);
				 tel.setCallerName(newTGHGenerator.getCallerName());
				 tel.setTGHSend_Date(newTGHGenerator.getSendDate());
				 tel.setGenId(newTGHGenerator.getId());
				 tel.setMessage(newTGHGenerator.getMessage());

				 tel.setSenderName(sender.getSenderName());
				 tel.setSenderName2(sender.getSenderName());

				 tel.setRecName(recepient.getRecName());
				 tel.setRecName2(recepient.getRecName());
				 tel.setAddress(recepient.getAddress());
				 
				 TGHRTelegraph_service.insertTelegraph(tel);
				 
//				 System.out.println("********************************************************************************************************************");
//				 System.out.println(tel);
//				 System.out.println("********************************************************************************************************************");
				 
				 Telegraphs.add(tel);
				 
//				 System.out.println("********************************************************************************************************************");
//				 System.out.println(Telegraphs);
//				 System.out.println("********************************************************************************************************************");
				 
				 newTGHGenerator.setTelegraphs(Telegraphs);
			 }

		 }



	    return newTGHGenerator;
	  }
	 
        @ApiOperation(value="Returns All Generators in pages") 
		@GetMapping("/all/{offset}/{pagesize}/{field}")
		public Page<TGHGenerator> getallgenerators(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
			return tghgeneratorserv.FindAllGenerators(offset,pagesize,field);
		}
	 
//        @ApiOperation(value="Returns All Telegraph") 
//		@GetMapping("/all")
//		public List<TGHGenerator> getallgenerators(){
//			return tghgeneratorserv.FindAllGenerators();
//		}
		
   	    
   	    @ApiOperation(value="Get Gen Id")
		@GetMapping("/GetGenId")
		public Long GetNextId(){
			return tghgeneratorserv.GetNextId();
		}
        
   	    @ApiOperation(value="Search Telegraphs Generators")
		@PostMapping("/Search/{offset}/{pagesize}")
		public Page<TGHGenerator> getbyattribute(@RequestBody TGHGeneratorSearch search,@PathVariable int offset,@PathVariable int pagesize){
   	    	
			return tghgeneratorserv.Findbyattribute(search,offset,pagesize);
		}
   	    
//   	    @ApiOperation(value="Search between two dates") 
//   		@GetMapping("/getbetweenDates/{date1}/{date2}")
//   		public List<TGHGenerator>getBetweenTwoDates(@PathVariable  String date1, @PathVariable  String date2)throws Exception
//   		{
//   	 		Date d1=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
//   			Date d2=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
//   			return  tghgeneratorserv.getBetweenTwoDates(d1,d2);
//   		}
}
