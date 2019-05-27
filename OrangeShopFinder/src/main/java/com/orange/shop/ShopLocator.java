package com.orange.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.Location;

import com.orange.shop.FileShopReader;
import com.orange.shop.Line;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicLine;
import net.sf.geographiclib.GeodesicMask;

public class ShopLocator implements OrangeShopFinder {
	
	private static List<Line> all_data= new ArrayList<Line>();
	private static Geodesic geod = Geodesic.WGS84;
	Location closestLocation;
	int smallestDistance = -1;
	
	public ShopLocator()
	{
		FileShopReader f = new FileShopReader();
		
		all_data = f.setAllLine();
		

	}



	@Override
	public Distance findOrangeShopWithMobileAvailable(double long1, double lat1, String nameMobile) {
		


		int key1=0;

		LinkedHashMap<Integer,Double> distances = new LinkedHashMap<Integer,Double>();
		if(nameMobile.equalsIgnoreCase("sunusng"))
		{

			int counter=-1;
			
			for (Line line : all_data) {
				counter++;
				if(Integer.parseInt(line.getField4())>0) {
					distances.put(counter, getDistance(lat1, long1, Double.parseDouble(line.getField2()),  Double.parseDouble(line.getField1())));
					
				
				}
				
			}

			distances=sortHashMapByValues(distances);

			 Map.Entry<Integer,Double> entry = distances.entrySet().iterator().next();
			 int key = entry.getKey();
			 double value = entry.getValue();

			 Distance d = new Distance(value,all_data.get(key));
			
			return d;
		}
		if(nameMobile.equalsIgnoreCase("weiwei"))
		{
			int counter=-1;
			
			for (Line line : all_data) {
				counter++;
				if(Integer.parseInt(line.getField6())>0) {
					distances.put(counter, getDistance(lat1, long1, Double.parseDouble(line.getField2()),  Double.parseDouble(line.getField1())));
					
				
				}
				
			}

			distances=sortHashMapByValues(distances);

			 Map.Entry<Integer,Double> entry = distances.entrySet().iterator().next();
			 int key = entry.getKey();
			 double value = entry.getValue();
			 Distance d = new Distance(value,all_data.get(key));
				
				return d;
			 }
		if(nameMobile.equalsIgnoreCase("ipom"))
		{
			int counter=-1;
			
			for (Line line : all_data) {
				counter++;
				if(Integer.parseInt(line.getField5())>0) {
					distances.put(counter, getDistance(lat1, long1, Double.parseDouble(line.getField2()),  Double.parseDouble(line.getField1())));
					
				
				}
				
			}

			distances=sortHashMapByValues(distances);

			 Map.Entry<Integer,Double> entry = distances.entrySet().iterator().next();
			 int key = entry.getKey();
			 double value = entry.getValue();
			 Distance d = new Distance(value,all_data.get(key));
				
				return d;
			 }
	
		 Distance d = new Distance(0,all_data.get(0));
			
			return d;
		
	}
	public static double getDistance(double lat1, double lon1, double lat2, double lon2) {
		  GeodesicLine line = geod.InverseLine(lat1, lon1, lat2, lon2, GeodesicMask.DISTANCE_IN | GeodesicMask.LATITUDE | GeodesicMask.LONGITUDE);
		  return Math.ceil(line.Distance()/1000);
		}
	
	public LinkedHashMap<Integer, Double> sortHashMapByValues(
	        HashMap<Integer, Double> passedMap) {
	    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Double> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    LinkedHashMap<Integer, Double> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Double> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Double val = valueIt.next();
	        Iterator<Integer> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Integer key = keyIt.next();
	            double comp1 = passedMap.get(key);
	            double comp2 = val;

	            if (comp1==(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}

}
