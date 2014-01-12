package com.example.nosqldemo.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Pick;
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
	
	public List<Zamowienie> getZam(String sklep) {
		return zamowienieRepository.findBySklep(sklep);
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
	
	public ArrayList<Pick> findPickInZam(String firma, String nameP) {
		ArrayList<Zamowienie> z = (ArrayList<Zamowienie>) zamowienieRepository.findBySklep(firma);
		ArrayList<Pick> picks = new ArrayList<Pick>();

		for (Pick p : z.get(0).getPicks()) {
			if (p.getName().equals(nameP))
				picks.add(p);
		}

		return picks;
	}
	
	public void deletePick(String firma, String nameP) {
		ArrayList<Zamowienie> z = (ArrayList<Zamowienie>) zamowienieRepository.findBySklep(firma);

		for (Pick p : z.get(0).getPicks()) {
			if (p.getName().equals(nameP))
				z.get(0).getPicks().remove(p);
		}

		zamowienieRepository.save(z);
	}
	
}
