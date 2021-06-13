package com.vipul.demand.demandrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vipul.demand.DemandItem;

public interface DemandItemRepository extends CrudRepository<DemandItem, Long> {
	
	public List<DemandItem> findByDemandID(long demandID);
	
	@Query(value="Select * from DemandItem where demandid in (Select demandid from demand where convert(date, date) = convert(date, ?1))", nativeQuery = true)
	public List<DemandItem> findByDemandDate(Date date);
}
