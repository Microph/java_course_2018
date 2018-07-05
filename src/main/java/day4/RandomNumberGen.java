package day4;

import java.util.Random;

public class RandomNumberGen {

    public int generateRandomNumber() {
        return new Random().nextInt(10);
    }

}
