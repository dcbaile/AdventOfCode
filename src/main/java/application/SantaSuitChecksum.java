package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SantaSuitChecksum {
    public static void main(String[] args) throws IOException {
        String string;
        File file = new File("../resources/santaWarehouseIds.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while((string = br.readLine()) != null){
                
            }
        }
    }

}
