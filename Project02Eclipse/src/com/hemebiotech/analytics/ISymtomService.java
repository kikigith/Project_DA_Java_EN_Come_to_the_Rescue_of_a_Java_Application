package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Classes implementing this service generate an ordered Map of symptoms with
 * their occurences The important part is, the return value from the operation,
 * which is a Map of <String, Integer>, no duplications allowed. The String(key)
 * is the symptom The Integer(value) is the number of occurence of the symptom
 * 
 * 
 */
public interface ISymtomService {

	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return A TreeMap that consists of symptoms with their respective frequency
	 *         no duplicate possible/probable
	 */
	public Map<String, Integer> generateAnalysis();
}
