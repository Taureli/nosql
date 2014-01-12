package com.example.nosqldemo.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Pick;
import com.example.nosqldemo.repository.PickRepository;

@Component
public class PickManager {

	@Autowired
	private  PickRepository pickRepository;
	
	public void addNewPick(Pick pick){
		pickRepository.save(pick);
	}
	
	public List<Pick> getPicksName(String name){
		return pickRepository.findByName(name);
	}
	
	public Pick getPickId(ObjectId id){
		return pickRepository.findById(id);
	}
	
	public void deletePick(Pick pick){
		pickRepository.delete(pick);
	}
	
	public void updateNamePick(String oldName, String newName){
		ArrayList<Pick> pick = (ArrayList<Pick>) pickRepository.findByName(oldName);
		pick.get(0).setName(newName);
		
		pickRepository.save(pick);
	}
	
	public void deleteAllPicks(){
		pickRepository.deleteAll();
	}
	
	public List<Pick> getAllPicks(){
		return (List<Pick>) pickRepository.findAll();
	}
	
	public List<Pick> findBetweenPrice(double minY, double maxY){
		return pickRepository.findBetweenPrice(minY, maxY);
	}
	
	public List<Pick> findPartName(String name){
		return (List<Pick>) pickRepository.findPartName(name);
	}
	
	
	
}
