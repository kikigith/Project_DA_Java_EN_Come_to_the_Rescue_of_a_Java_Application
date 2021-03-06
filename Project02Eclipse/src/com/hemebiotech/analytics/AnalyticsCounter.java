package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		String workingDir = System.getProperty("user.dir");
		String filepath = workingDir + "/symptoms.txt";

		ISymptomReader rsDF = new ReadSymptomDataFromFile(filepath);
		ISymtomService symService = new SymptomService(rsDF);
		// next generate output
		try {
			FileWriter writer = new FileWriter("result.out");
			IAnalysisWriter anWriter = new WriteAnalyticsToFile(writer, symService.generateAnalysis());
			anWriter.printResult();
			writer.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
