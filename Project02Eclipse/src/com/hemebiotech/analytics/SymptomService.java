package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <b>SymptomService </b> a business service handling symptoms trends
 * 
 * @author kiki
 * 
 *
 */
public class SymptomService {
	private ISymptomReader symptomReader;

	public SymptomService(ISymptomReader sReader) {
		this.symptomReader = sReader;
	}

	/**
	 * 
	 * @return A sorted HashMap that consists of symptoms with their respective
	 *         frequency
	 */
	public Map<String, Integer> generateAnalysis() {
		List<String> symptoms = symptomReader.GetSymptoms().stream().sorted().collect(Collectors.toList());
		Map<String, Integer> result = new HashMap<String, Integer>();

		for (String us : symptoms) {
			int usOccurence = Collections.frequency(symptoms, us);
			result.put(us, usOccurence);
		}
		Map<String, Integer> sortedResult = result.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		return sortedResult;
	}

//	/**
//	 * 
//	 * @param writer : file to write the analysis to
//	 */
//	public void printAnalysis(FileWriter writer) {
//		Map<String, Integer> analysis = generateAnalysis();
//
//		analysis.forEach((s, k) -> {
//			try {
//				writer.write(s + ":" + k + "\n");
//			} catch (IOException ioe) {
//				ioe.getMessage();
//			}
//		});
//
//	}

//	public void buildMap(String symptom, Map<String, Integer> m) {
//	
//	m.merge(symptom, 1,(0,n) ->{
//		return 0+n;
//	});
//}

}
