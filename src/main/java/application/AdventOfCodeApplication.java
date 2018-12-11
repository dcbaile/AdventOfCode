package application;

import java.io.*;

public class AdventOfCodeApplication {
	public static void main(String[] args)throws IOException {
		File file = new File("C:\\Users\\dcbaile\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\adventFrequencyNumbers.txt");
		//File newFile = new File("C:\\Users\\dcbaile\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\sample.txt");
		String frequency = FrequencyCalibrator.getFrequency(file);
		System.out.println(frequency);
	}
}
