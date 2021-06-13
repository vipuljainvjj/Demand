package com.vipul.demand.demandrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vipul.demand.Demand;


public interface DemandRepository extends CrudRepository<Demand, Long> {
	
	@Query(value="Select * from demand where convert(date, date) = ?1", nativeQuery = true)
	List<Demand> findByDate(Date parseDate);
}
