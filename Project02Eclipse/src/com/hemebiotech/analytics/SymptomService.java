package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <b>SymptomService </b> a business service handling symptoms trends
 * 
 * @author kiki
 * 
 *
 */
public class SymptomService implements ISymtomService {
	private ISymptomReader symptomReader;

	public SymptomService(ISymptomReader sReader) {
		this.symptomReader = sReader;
	}

	/**
	 * 
	 * @return A TreeMap that consists of symptoms with their respective frequency
	 */
	@Override
	public Map<String, Integer> generateAnalysis() {
		System.out.println("Start method SymptomService.generateAnalysis");

		List<String> symptoms = symptomReader.GetSymptoms();
		Map<String, Integer> result = new TreeMap<String, Integer>();

		for (String symptom : symptoms) {
			if (!result.containsKey(symptom)) {
				result.put(symptom, Collections.frequency(symptoms, symptom));
			}
		}

		System.out.println("End method SymptomService.generateAnalysis");
		return result;
	}

}
