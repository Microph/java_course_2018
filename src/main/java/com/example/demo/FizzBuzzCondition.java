package com.example.demo;

public class FizzBuzzCondition implements Condition {
    @Override
    public int getIntCheck() {
        return 15;
    }

    @Override
    public boolean check(int input) {
        // TODO Auto-generated method stub
        return input%15 == 0;
    }

    @Override
    public String say(int input) {
        // TODO Auto-generated method stub
        return "FizzBuzz";
    }
  
}
