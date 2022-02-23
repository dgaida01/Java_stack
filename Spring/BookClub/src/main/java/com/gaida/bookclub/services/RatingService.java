package com.gaida.bookclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaida.bookclub.models.Rating;
import com.gaida.bookclub.repositories.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	RatingRepository rateRepo;
//	@Autowired
//	BookRepository bookRepo;
//	@Autowired
//	UserRepository userRepo;
	

	public void createRating(Rating theScore) {
		this.rateRepo.save(theScore);
	}

}
