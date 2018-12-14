package application;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SubterraneanSustainability {
    static String row = "#..#.#..##......###...###";
    static String newRow;
    static HashMap<String, String> rules = new HashMap<>();

    public static void main(String[] args) {
        rules = getRules();
        doStuff();
    }
    public static void doStuff(){
        if(row.charAt(0) == '#' || row.charAt(1) == '#' || row.charAt(row.length()) == '#' || row.charAt(row.length()+1) == '#'){
            row = ".." + row + "..";
            System.out.println(row);
        }
        newRow = makeNewRowOfLength(row.length());
        for (String rule: rules.keySet()) {
            int index = row.indexOf(rule);
            while(index > -1){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.replace
            }
        }
        System.out.println(newRow);

    }
    public static String makeNewRowOfLength(int length){
        char[] myCharArray = new char[length];

        for(int i = 0; i < myCharArray.length; i++){
            myCharArray[i] = '.';
        }
        return String.valueOf(myCharArray);
    }

    public static HashMap<String, String> getRules(){
        HashMap<String, String> rules = new HashMap<>();
        rules.put("...##", "#");
        rules.put("..#..", "#");
        rules.put(".#...", "#");
        rules.put(".#.#.", "#");
        rules.put(".#.##", "#");
        rules.put(".##..", "#");
        rules.put(".####", "#");
        rules.put("#.#.#", "#");
        rules.put("#.###", "#");
        rules.put("##.#.", "#");
        rules.put("##.##", "#");
        rules.put("###..", "#");
        rules.put("###.#", "#");
        rules.put("####.", "#");
        return rules;
    }
}
