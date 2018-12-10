package application;

import java.io.*;

public class AdventOfCodeApplication {
	public static void main(String[] args)throws IOException {
		File file = new File("/Users/dylanbailey/IdeaProjects/AdventOfCode/src/main/resources/adventFrequencyNumbers.txt");
		String frequency = FrequencyCalibrator.getFrequency(file);
		System.out.println(frequency);
	}
}
