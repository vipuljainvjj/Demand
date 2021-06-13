package com.vipul.demand.demandController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipul.demand.Demand;
import com.vipul.demand.DemandItem;
import com.vipul.demand.DemandItemData;
import com.vipul.demand.Exception.DemandItemNotFoundException;
import com.vipul.demand.Exception.DemandNotFoundException;
import com.vipul.demand.demandrepository.DemandItemRepository;
import com.vipul.demand.demandrepository.DemandRepository;
import com.vipul.demand.demandutil.DateUtil;

@RestController
class DemandItemController {
	
	@Autowired
	DemandRepository demandRepo;
	
	@Autowired
	DemandItemRepository dItemRepo;
	
	@GetMapping(value="demand/{date}/demanditems", produces=MediaType.APPLICATION_JSON_VALUE)
	private Map<Long, List<DemandItemData>> getAllDemandItems(@PathVariable String date ) {
		date = date.replace("-", "/");
		Date parseDate = DateUtil.formatDate(date);
		List<DemandItem> demandItemList = dItemRepo.findByDemandDate(parseDate);
		System.out.println(demandItemList.size());
		List<DemandItemData> demandItemDataList = demandItemList.stream()
																.map(DemandItem::getDemandItemData)
																.collect(Collectors.toList());
		return demandItemDataList.stream()
								 .collect(Collectors.groupingBy(DemandItemData::getDemandID));
	}
	
	@GetMapping(value="/demanditem/{id}")
	private DemandItemData getDemandItem(@PathVariable long id) {
		DemandItem demandItem = dItemRepo.findById(id).orElseThrow( () -> new DemandItemNotFoundException());
		return demandItem.getDemandItemData();
	}
	
	@PostMapping(value="/demandItem", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private ResponseEntity<List<DemandItemData>> createDemandItem(@RequestBody List<DemandItemData> jsonInput ) {
		List<DemandItem> demandItems = jsonInput.stream()
												.map(DemandItem::setDemandItem)
												.collect(Collectors.toList());
		demandItems = (List<DemandItem>) dItemRepo.saveAll(demandItems);

		return new ResponseEntity<List<DemandItemData>>(demandItems.stream()
																   .map(DemandItem::getDemandItemData)
																   .collect(Collectors.toList()), 
														HttpStatus.CREATED
		);
	}	
}