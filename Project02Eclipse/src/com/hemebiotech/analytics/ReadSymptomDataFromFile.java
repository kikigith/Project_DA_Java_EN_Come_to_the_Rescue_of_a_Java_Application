package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		System.out.println("Start method ReadSymptomDataFromFile.GetSymptoms");
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filepath));) {

				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

			} catch (FileNotFoundException fnfe) {
				System.out.println("File " + filepath + " not found");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("End method ReadSymptomDataFromFile.GetSymptoms");
		return result;
	}

	/**
	 * @return a set of symptoms
	 */
	@Override
	public Set<String> GetSymptomsSet() {
		Set<String> result = new TreeSet<String>(this.GetSymptoms());
		return result;

	}
}
