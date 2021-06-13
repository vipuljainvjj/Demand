package com.vipul.demand.demandrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vipul.demand.DemandItem;

public interface DemandItemRepository extends CrudRepository<DemandItem, Long> {
	
	public List<DemandItem> findByDemandDate(Date date);

}
