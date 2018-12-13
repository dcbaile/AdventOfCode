package application;

import org.junit.Assert;
import org.junit.Test;

public class SubterraneanSustainability {
    String testSequence = "#..#.#..##......###...###";
    String rule = "...##";
    public static void main(String[] args) {

    }

    @Test
    public void test(){

    }
    public String getNextGeneration(){
        String initializedState = "#..#.#..##......###...###";
        return "";
    }

    public String putPlant(String sequence){
        String nextGen = sequence.substring(0,2) + "#" + sequence.substring(3,5);
        return nextGen;
    }
    public String removePlant(String sequence){
        String nextGen = sequence.substring(0,2) + "#" + sequence.substring(3,5);
        return nextGen;
    }

    @Test
    public void getPlantIndex_returnsCorrectIndex(){
        String myString = ".#.#.###";
        Assert.assertTrue(getPlantIndex("#.#.#", myString) == 3);
    }
    public boolean doesRuleApply(String rule, String state){
        return state.contains(rule);
    }
    @Test
    public void test4(){
        if(doesRuleApply(rule, testSequence)){
            String strang = testSequence.replace(rule, putPlant(rule));
            Assert.assertEquals(strang, "#..#.#..##.....####..####");
        }
    }

    public int getPlantIndex(String rule, String state){
        return state.indexOf(rule)+2;
    }
    @Test
    public void putPlant_sampleStringNoPlant_addsPlant(){
        String nextGen = putPlant(".....");
        Assert.assertTrue(nextGen.equals("..#.."));
    }
    /**
     * initial state: #..#.#..##......###...###
     *
     * ...## => #
     * ..#.. => #
     * .#... => #
     * .#.#. => #
     * .#.## => #
     * .##.. => #
     * .#### => #
     * #.#.# => #
     * #.### => #
     * ##.#. => #
     * ##.## => #
     * ###.. => #
     * ###.# => #
     * ####. => #
     */
}
