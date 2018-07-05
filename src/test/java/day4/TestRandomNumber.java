package day4;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestRandomNumber {

    @Test
    public void testRandom(){
        RandomNumberGen randomNumberGen = new RandomNumberGen();
        assertEquals(5, randomNumberGen.generateRandomNumber(new Random5()));  
    }

}

class Random5 extends Random{
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}