package application;

import java.io.*;

public class FrequencyCalibrator {
	private FrequencyCalibrator(){

	}
	public static String getFrequency(File calibrationFile)throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(calibrationFile))){
			String str ;
			int frequency = 0;
			int oldFrequency = 0;
			while((str = br.readLine())!= null){
				oldFrequency = frequency;
				frequency+= Integer.valueOf(str);
				System.out.format("Current frequency is %d, change of %d; result frequency %d \n", oldFrequency, Integer.valueOf(str), frequency);
			}
			return String.valueOf(frequency);
		}
	}
}
