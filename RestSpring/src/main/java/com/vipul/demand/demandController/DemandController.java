package com.vipul.demand.demandController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipul.demand.Demand;
import com.vipul.demand.DemandData;
import com.vipul.demand.DemandItem;
import com.vipul.demand.DemandItemData;
import com.vipul.demand.Exception.DemandNotFoundException;
import com.vipul.demand.demandrepository.DemandItemRepository;
import com.vipul.demand.demandrepository.DemandRepository;

@RestController
public class DemandController {
	
	@Autowired
	DemandRepository demandRepo;
	
	@Autowired
	DemandItemRepository demandItemRepo;
	
	@GetMapping(value="/demands", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<DemandData> testGet() {
		System.out.println("Get Request");
		List<Demand> list = (List<Demand>) demandRepo.findAll();
		return list.stream().map(Demand::getDemandData).collect(Collectors.toList());
	}
	
	@GetMapping(value="/demand/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public DemandData getDemand(@PathVariable long id) {
		Demand demand = demandRepo.findById(id).orElseThrow(() -> new DemandNotFoundException());
		return demand.getDemandData(); 
	}
	
//	@GetMapping(value="/demand/{date}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public DemandData getDemandByDate(@PathVariable Date date) {
//		Demand demand = demandRepo.findByDate(date).orElseThrow(() -> new DemandNotFoundException());
//		return demand.getDemandData();
//	}
	
	@PostMapping(value="/demand", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<DemandData> createPost(@RequestBody DemandData jsonInput) {
		System.out.println("Post request");
		Demand demand = Demand.setDemand(jsonInput);
		demand = demandRepo.save(demand);
		
		List<DemandItem> demandItems = jsonInput.getDemandItems()
										.stream()
										.map(DemandItem::setDemandItem)
										.collect(Collectors.toList());
		demandItems = (List<DemandItem>) demandItemRepo.saveAll(demandItems);
		
		// get POJO bean to return
		DemandData demandData = demand.getDemandData();
		demandData.setDemandItems(demandItems.stream()
									 .map(DemandItem::getDemandItemData)
									 .peek(dItemData -> dItemData.setDemandID(demandData.getDemandID()))
									 .collect(Collectors.toList())
 		);
		return new ResponseEntity<DemandData>(demandData, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/demand", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	@ResponseBody
	public String testPut(@RequestBody DemandData jsonInput) {
		System.out.println("Put Request");
		return "";
	}
	
	@DeleteMapping(value="/demand", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String testDelete(@RequestBody DemandData jsonInput) {
		System.out.println("Delete Mapping");
		return "";
	}
	
	@RequestMapping(value="/demand", method=RequestMethod.HEAD, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String testHead(@RequestBody DemandData jsonInput) {
		System.out.println("Head Mapping");
		return "";
	}
	
	@RequestMapping(value="/demand", method=RequestMethod.PATCH, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String testPatch(@RequestBody DemandData jsonInput) {
		System.out.println("Patch Mapping");
		return "";
	}
	
	@RequestMapping(value="/demand", method=RequestMethod.OPTIONS, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String testOptions(@RequestBody DemandData jsonInput) {
		System.out.println("Options Mapping");
		return "";
	}
	
	@RequestMapping(value="/demand", method=RequestMethod.TRACE, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String testTrace(@RequestBody DemandData jsonInput) {
		System.out.println("Trace Mapping");
		return "";
	}
}