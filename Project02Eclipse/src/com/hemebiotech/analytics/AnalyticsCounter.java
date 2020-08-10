package com.hemebiotech.analytics;

import java.io.FileWriter;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		String workingDir = System.getProperty("user.dir");
		String filepath = workingDir + "/Project02Eclipse/symptoms.txt";

		ISymptomReader rsDF = new ReadSymptomDataFromFile(filepath);
		// next generate output
		FileWriter writer = new FileWriter("result.out");

		SymptomService symService = new SymptomService(rsDF);
		IAnalysisWriter anWriter = new WriteAnalyticsToFile(writer, symService.generateAnalysis());
		anWriter.printResult();
		writer.close();
	}
}
