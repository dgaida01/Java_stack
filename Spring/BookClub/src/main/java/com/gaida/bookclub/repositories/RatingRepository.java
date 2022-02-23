package com.gaida.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaida.bookclub.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository <Rating,Long> {

}
