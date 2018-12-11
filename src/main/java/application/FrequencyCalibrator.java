package application;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCalibrator {
	private FrequencyCalibrator(){

	}
	public static String getFrequency(File calibrationFile)throws IOException {
		String str;
		Integer frequency = 0;
		int oldFrequency = 0;
		int count = 0;
		boolean repeated = false;
		Map<String, Integer> hm = new HashMap();
		hm.put(String.valueOf(0), 1);
		while (repeated == false) {
			try (BufferedReader br = new BufferedReader(new FileReader(calibrationFile))) {
				while ((str = br.readLine()) != null) {
					oldFrequency = frequency;
					frequency += Integer.valueOf(str);
					if (hm.containsKey(String.valueOf(frequency))) {
						repeated = true;
						System.out.println("The first repeating frequency is : " + frequency);
					} else {
						hm.put(String.valueOf(frequency), 1);
					}
					System.out.format("Current frequency is %d, change of %d; result frequency %d \n", oldFrequency, Integer.valueOf(str), frequency);
				}
				//System.out.println(hm.size());
				//System.out.println("iteration finished");
				//System.out.println("*******************************************\n\n\n\n\n");
			}
		}
		return String.valueOf(frequency);
	}
}
