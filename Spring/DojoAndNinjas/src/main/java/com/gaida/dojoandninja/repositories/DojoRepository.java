package com.gaida.dojoandninja.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaida.dojoandninja.models.Dojo;




@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	
}
