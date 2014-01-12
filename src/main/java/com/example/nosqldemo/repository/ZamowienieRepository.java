package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Zamowienie;

public interface ZamowienieRepository extends CrudRepository<Zamowienie, ObjectId> {
	
	List<Zamowienie> findBySklep(String sklep);
	
	Zamowienie findById(ObjectId id);

}
