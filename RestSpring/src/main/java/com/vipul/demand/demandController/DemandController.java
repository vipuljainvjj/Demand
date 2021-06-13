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
	private List<DemandData> getAllDemands() {
		System.out.println("Get All Demand Request");
		List<Demand> list = (List<Demand>) demandRepo.findAll();
		return list.stream().map(Demand::getDemandData).collect(Collectors.toList());
	}
	
	@GetMapping(value="/demand/{date}", produces=MediaType.APPLICATION_JSON_VALUE)
	private DemandData getDemandByDate(@PathVariable Date date) {
		System.out.println("get a demand request");
		Demand demand = demandRepo.findByDate(date).orElseThrow(() -> new DemandNotFoundException());
		return demand.getDemandData();
	}
	
	@PostMapping(value="/demand", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private ResponseEntity<DemandData> createDemand(@RequestBody DemandData jsonInput) {
		System.out.println("Create a demand request");
		Demand demand = Demand.setDemand(jsonInput);
		demand = demandRepo.save(demand);
		return new ResponseEntity<DemandData>(demand.getDemandData(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/demand{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private void deleteDemand(@PathVariable long id) {
		System.out.println("Delete Mapping");
		demandRepo.deleteById(id);
	}
}