package com.example.nosqldemo.domain;

import java.util.List;

import org.bson.types.ObjectId;

public class Zamowienie {

	private ObjectId id;
	private String sklep;
	
	private List<Pick> picks;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getSklep() {
		return sklep;
	}

	public void setSklep(String sklep) {
		this.sklep = sklep;
	}

	public List<Pick> getPicks() {
		return picks;
	}

	public void setPicks(List<Pick> picks) {
		this.picks = picks;
	}
	
	
}
