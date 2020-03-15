package com.nikhil.universe;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
	private final String name;
	private final int orbitPeriod;
	private final Set<HeavenlyBody> satellites;
	private final BodyTypes bodyTypes;
	
	public enum BodyTypes{
		STAR,
		PLANET,
		MOON,
		COMET,
		ASTEROID
	}
	
	public HeavenlyBody(String name,int orbitPeriod,BodyTypes bodyTypes) {
		this.name=name;
		this.orbitPeriod=orbitPeriod;
		this.bodyTypes=bodyTypes;
		this.satellites=new HashSet<>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getOrbitPeriod() {
		return orbitPeriod;
	}
	public BodyTypes getBodyTypes() {
		return bodyTypes;
	}
	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<HeavenlyBody>(satellites);
	}
	public boolean addSatellite(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof HeavenlyBody) {
			HeavenlyBody h=(HeavenlyBody)obj;
			//If both objects have same name and same bodyType then they are equal.
			if(this.name.equals(h.getName())) {   
				return this.bodyTypes.equals(h.getBodyTypes());
			}
		}
		return false;
	}
	
	//If two objects are equal then their hashcodes should be equal.
	@Override
	public int hashCode() {
		return this.name.hashCode()+this.bodyTypes.hashCode();
	}

}
