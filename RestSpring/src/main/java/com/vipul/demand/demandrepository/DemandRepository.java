package com.vipul.demand.demandrepository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vipul.demand.Demand;


public interface DemandRepository extends CrudRepository<Demand, Long> {
	
	Optional<Demand> findByDate(Date date);
}
