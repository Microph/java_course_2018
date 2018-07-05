package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRandomNumber {

    @Test
    public void testRandom(){
        RandomNumberGen randomNumberGen = new RandomNumberGen();
        assertEquals(5, randomNumberGen.generateRandomNumber());  
    }

}
