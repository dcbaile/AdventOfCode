package application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class SantaSuitChecksumTest {
    private ArrayList<String> sampleArrayList = new ArrayList<>();
    private int checkSum;
    /*
    abcdef contains no letters that appear exactly two or three times.
  - bababc contains two a and three b, so it counts for both.
  - abbcde contains two b, but no letter appears exactly three times.
  - abcccd contains three c, but no letter appears exactly two times.
  - aabcdd contains two a and two d, but it only counts once.
  - abcdee contains two e.
  - ababab contains three a and three b, but it only counts once.

Of these box IDs, four of them contain a letter which appears exactly twice, and three of them contain a letter which appears exactly three times. Multiplying these together produces a checksum of 4 * 3 = 12.

     */
    @Before
    public void setUp() throws Exception {
        sampleArrayList.add("abcdef");
        sampleArrayList.add("bababc");
        sampleArrayList.add("abbcde");
        sampleArrayList.add("abcccd");
        sampleArrayList.add("aabcdd");
        sampleArrayList.add("abcdee");
        sampleArrayList.add("ababab");
    }
    @Test
    public void sampleData_shouldReturn12(){
        Assert.assertTrue(SantaSuitChecksum.getCheckSum(sampleArrayList) == 12);
    }

    @Test
    public void countChars_shouldReturn1(){
        checkSum = SantaSuitChecksum.countChars("a", sampleArrayList.get(0));
        Assert.assertTrue(checkSum == 1);
    }
    @Test
    public void countChars_shouleReturn3(){
        checkSum = SantaSuitChecksum.countChars("b", sampleArrayList.get(1));
        Assert.assertTrue(checkSum == 3);
    }
    @Test
    public void countChars_shouldReturn2(){
        checkSum = SantaSuitChecksum.countChars("d", sampleArrayList.get(4));
        Assert.assertTrue(checkSum == 2);
    }

}