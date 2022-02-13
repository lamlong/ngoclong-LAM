package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class AnalyticsCounter {

	
	public static void main(String args[]) throws Exception {
		// first get input
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		 List<String> listSymptom = reader.GetSymptoms();
		
		 String symptom;
		 int compteur;
		 TreeMap<String, Integer> mapSymptom  = new TreeMap<String , Integer>();
		 // parcourir la liste et compter les symptoms
		 for (int i = 0; i< listSymptom.size(); i++)
		 {
			 symptom = listSymptom.get(i);
			 compteur = 0;
			 for (int j = 0; j< listSymptom.size();j++) {
				 if(symptom.equals(listSymptom.get(j)))
					 compteur++;
			 }
			 
			 // sauvegarder l'information compteur/symptom (map ou treemap )
			 if(!mapSymptom.containsKey(symptom))
				 mapSymptom.put(symptom, compteur);
			 
			
		 }
		 // trier le tableau du resulat 
	
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		for (String sym : mapSymptom.keySet()) {
			writer.write(sym +":"+ mapSymptom.get(sym)  + "\n");
		}
		
		writer.close();
	}
	
	
}
