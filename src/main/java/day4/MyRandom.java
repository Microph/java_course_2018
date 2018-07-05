package day4;

import java.util.Random;

public class MyRandom implements DemoRandom{

    public int nextInt(int bound) {
        // TODO Auto-generated method stub
        return new Random().nextInt(bound);
    }

}
