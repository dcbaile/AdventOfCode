package application;

import com.sun.deploy.util.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class SubterraneanSustainability {
    static String row = "#..#.#..##......###...###";
    static String newRow;
    static HashMap<String, String> rules = new HashMap<>();
    static int plantCount = 0;

    public static void main(String[] args) {
        rules = getRules();
        doStuff();
    }

    public static void doStuff() {
        for (int i = 0; i < 20; i++) {
            if (row.charAt(0) == '#' || row.charAt(1) == '#' || row.charAt(row.length()-2) == '#' || row.charAt(row.length()-1) == '#') {
                StringBuilder builder = new StringBuilder();
                builder.append("..").append(row).append("..");
                row = builder.toString();
                System.out.println(i + ": " + row);
            }
            newRow = makeNewRowOfLength(row.length());
            for (String rule : rules.keySet()) {

                String tempRow = row;
                int index = 0;
                int offset = 0;
                while (index > -1) {
                    index = tempRow.indexOf(rule);
                    if (index > -1) {
                        System.out.println(rule + "matches at index " + (index+offset));
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(newRow);
                        stringBuilder.replace(index + offset, index + offset + 1, rules.get(rule));
                        newRow = stringBuilder.toString();
                        offset++;
                        tempRow = tempRow.substring(1);
                    }
                }
            }
            plantCount += row.length() - row.replace("#", "").length();
            row = newRow;
        }
        plantCount += row.length() - row.replace("#", "").length();
        System.out.println(plantCount);
    }

    public static String makeNewRowOfLength(int length) {
        char[] myCharArray = new char[length];

        for (int i = 0; i < myCharArray.length; i++) {
            myCharArray[i] = '.';
        }
        return String.valueOf(myCharArray);
    }

    public static HashMap<String, String> getRules() {
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
