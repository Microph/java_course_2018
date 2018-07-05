package day4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestStream {
    private String input = "";
    private String expectedOutput = "";
    
    public TestStream(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> getAbbreviation() {
        return Arrays.asList(new Object[][] {
                { "United States of America", "USA" },
                { "united states of america", "USA" },
                { "Jordan of the World", "JTW" },
                { "Light Amplification by Stimulated Emission of Radiation", "LASER" },
        });
    }
    
    @Test
    public void testUSA(){
        AbbreviationGen abbreviationGen = new AbbreviationGen();
        assertEquals(expectedOutput, abbreviationGen.generateAbbreviation(input));  
    }

}
