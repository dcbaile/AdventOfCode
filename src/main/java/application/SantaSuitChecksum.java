package application;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SantaSuitChecksum {
    public static void main(String[] args) throws IOException {
        String string;
        ArrayList<String> idList = new ArrayList<>();
        File file = new File("C:\\Users\\dcbaile\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\santaWarehouseIds.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while((string = br.readLine()) != null){
                idList.add(string);
            }
        }
        System.out.println("CheckSum for id list is " + getCheckSum(idList));
        getSimilarString(idList);
    }

    public static void getSimilarString(ArrayList<String> sampleArrayList){
        int stringDistance = 0;
        for(int i = 0; i<sampleArrayList.size(); i++){
            for(int j = i+1; j < sampleArrayList.size(); j++){
                stringDistance = calculate(sampleArrayList.get(i), sampleArrayList.get(j));
                if(stringDistance == 1){
                    System.out.println(sampleArrayList.get(i) + " and " + sampleArrayList.get(j));
                }
            }
        }
    }
    public static int getCheckSum(ArrayList<String> sampleArrayList) {
        int threes = 0;
        int twos = 0;
        boolean twosPresent;
        boolean threesPresent;
        int count = 0;
        char[] charArray;
        for (String id: sampleArrayList) {
            twosPresent = false;
            threesPresent = false;
            while (!id.equals("")){
                count = countChars(String.valueOf(id.charAt(0)), id);

                id = id.replace(String.valueOf(id.charAt(0)), "");
                if(count == 3 && !threesPresent){
                    threes++;
                    threesPresent = true;
                }
                if(count == 2 && !twosPresent){
                    twos++;
                    twosPresent = true;
                }
            }
            //id.
            //CharArrayReader reader = new CharArrayReader(charArray);
        }
        return twos*threes;
    }
    public static int countChars(String letter, String id){
        int precount = 0;
        int count = 0;
        precount = id.length();
        count = id.replace(letter, "").length();

        return precount - count;
    }

    static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }
    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
