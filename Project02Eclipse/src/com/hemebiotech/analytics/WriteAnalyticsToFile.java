package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * <b>WriteAnalytics </b> class used to save a Map<String, Integer> into a text
 * file
 * 
 * @author kiki
 *
 */
public class WriteAnalyticsToFile implements IAnalysisWriter {

	private FileWriter fwriter;
	private Map<String, Integer> analysis;

	public WriteAnalyticsToFile(FileWriter fw, Map<String, Integer> analysis) {
		this.fwriter = fw;
		this.analysis = analysis;
	}

	/**
	 * Write the content of the <i>analysis</i> map into <i>writer</i> file
	 */
	@Override
	public void printResult() {
		System.out.println("Start method WriteAnalyticsToFile.GetSymptoms");
		analysis.forEach((key, value) -> {
			try {
				fwriter.write(key + ":" + value + "\n");
			} catch (IOException ioe) {
				ioe.getMessage();
			}
		});
		System.out.println("End method WriteAnalyticsToFile.GetSymptoms");
	}

}
