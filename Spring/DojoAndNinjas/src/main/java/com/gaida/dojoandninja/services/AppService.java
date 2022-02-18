package com.gaida.dojoandninja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gaida.dojoandninja.models.Dojo;
import com.gaida.dojoandninja.models.Ninja;
import com.gaida.dojoandninja.repositories.DojoRepository;
import com.gaida.dojoandninja.repositories.NinjaRepository;

@Service
public class AppService {
	
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public AppService(DojoRepository dojoRepo,NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}

	
	public List<Dojo> findAllDojo() {
		return (List <Dojo>) this.dojoRepo.findAll();
			
	}
	
	public Dojo findByIDDojo(long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	public Dojo updateDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	
	public void deleteDojo(long id) {
		this.dojoRepo.deleteById(id);
	}
	
	public List<Ninja> findAllNinja() {
		return (List <Ninja>) this.ninjaRepo.findAll();
	}
	
	public Ninja findByIDNinja(long id) {
		return this.ninjaRepo.findById(id).orElse(null);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	public Ninja updateNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
}
