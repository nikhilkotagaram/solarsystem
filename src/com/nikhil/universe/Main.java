package com.nikhil.universe;

import java.util.*;

public class Main {
	private static Map<String,HeavenlyBody> solarSystem=new HashMap<>();
	private static Set<HeavenlyBody> planets=new HashSet<>();

	public static void main(String[] args) {
		
		HeavenlyBody temp=new Planet("Mercury",88);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new Planet("Venus",225);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new Planet("Earth",365);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);
		
		HeavenlyBody tempMoon=new Moon("moon",1);
		solarSystem.put(temp.getName(), temp);
		temp.addSatellite(tempMoon);
		
		tempMoon=new Moon("Aqua",45);
		solarSystem.put(temp.getName(), temp);
		temp.addSatellite(tempMoon);
		
		tempMoon=new Moon("Ikonos",8);
		solarSystem.put(temp.getName(), temp);
		temp.addSatellite(tempMoon);
		
		temp=new Planet("Mars",687);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);
		
		tempMoon=new Moon("phobos",3);
		solarSystem.put(temp.getName(), temp);
		temp.addSatellite(tempMoon);
		
		tempMoon=new Moon("Deimos",7);
		solarSystem.put(temp.getName(), temp);
		temp.addSatellite(tempMoon);
		
		
		HeavenlyBody hb=solarSystem.get("Mars");
		System.out.println(hb.getName());
		for(HeavenlyBody p:hb.getSatellites()) {
			System.out.println(p.getName());
		}
		
		Set<HeavenlyBody> moons=new HashSet<>();
		for(HeavenlyBody moon:planets) {
			moons.addAll(moon.getSatellites());
		}
		
		System.out.println("All moons");
		for(HeavenlyBody moon:moons) {
			System.out.print(moon.getName() +" ");
		}
		
		temp=new Planet("Pluto",986);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp=new Planet("Pluto",765);           //clearly pluto is already present
		solarSystem.put(temp.getName(), temp);  //overridden in the map
		planets.add(temp);                      //rejected or not added into set
		
		//checking in set
		System.out.println("All planets present");
		for(HeavenlyBody planet:planets) {
			System.out.println(planet.getName()+" "+planet.getOrbitPeriod());
		}
		
		//checking in map
		System.out.println("Planets added into map");
		for(String key:solarSystem.keySet()) {
			System.out.println(solarSystem.get(key).getName()+" "+solarSystem.get(key).getOrbitPeriod());
		}
		

	}

}
