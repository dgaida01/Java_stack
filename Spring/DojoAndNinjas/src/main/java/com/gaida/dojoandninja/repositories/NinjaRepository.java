package com.gaida.dojoandninja.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaida.dojoandninja.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{
	
	
	

}
