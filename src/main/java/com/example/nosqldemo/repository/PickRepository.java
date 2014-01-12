package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Pick;

public interface PickRepository extends CrudRepository<Pick, ObjectId>{
	
	List<Pick> findByName(String name);
	
	List<Pick> findByAmount(int amount);
	
	@Query(value = "{ 'price' : {'$gt' : ?0, '$lt' : ?1 } }" )
	List<Pick> findBetweenPrice(double minY, double maxY);
	
	@Query(value = "{ 'name' : {'$regex' : ?0} }" )
	List<Pick> findPartName(String name);
	
	Pick findById(ObjectId id);

}
