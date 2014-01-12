package com.example.nosqldemo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Zamowienie;
import com.example.nosqldemo.repository.ZamowienieRepository;

@Component
public class ZamowienieManager {

	@Autowired
	private  ZamowienieRepository zamowienieRepository;
	
	public void addNewZam(Zamowienie zamowienie){
		zamowienieRepository.save(zamowienie);
	}
	
	public Zamowienie getZamId(ObjectId id){
		return zamowienieRepository.findById(id);
	}
	
	public void deleteZam(Zamowienie zamowienie){
		zamowienieRepository.delete(zamowienie);
	}
	
	public void deleteAllZam(){
		zamowienieRepository.deleteAll();
	}
	
	public List<Zamowienie> getAllZam(){
		return (List<Zamowienie>) zamowienieRepository.findAll();
	}
	
	
	
}
