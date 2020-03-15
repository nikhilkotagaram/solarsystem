package com.nikhil.universe;

public class Planet extends HeavenlyBody {

	public Planet(String name, int orbitPeriod) {
		super(name, orbitPeriod, BodyTypes.PLANET);
	}
	
	@Override
	public boolean addSatellite(HeavenlyBody moon) {
		if(moon.getBodyTypes()==BodyTypes.MOON ) {
			return super.addSatellite(moon);
		}
		return false;
	}
	

}
