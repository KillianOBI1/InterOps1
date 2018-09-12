package com.ex1.model;

import java.util.ArrayList;
import java.util.List;

public class Gestionnaire {
	
	protected List<Carnet> carnets;
	
	public Gestionnaire() {
		this.carnets = new ArrayList<Carnet>();
	}
	
	public List<Carnet> getCarnets() {
		return this.carnets;
	}
	
	public void addCarnet(Carnet c) {
		if(!this.carnets.contains(c)) this.carnets.add(c);
	}
	
	public void removeCarnet(Carnet c) {
		if(this.carnets.contains(c)) this.carnets.remove(c);
	}
	
	public Carnet getCarnetById(int id) {
		for(Carnet c : carnets) {
			if(c.getId() == id) return c;
		}
		return null;
	}
	
}
