package com.example.demo;

public class BuzzCondition implements Condition {

    @Override
    public int getIntCheck() {
        // TODO Auto-generated method stub
        return 5;
    }

    @Override
    public boolean check(int input) {
        // TODO Auto-generated method stub
        return input%5==0;
    }

    @Override
    public String say(int input) {
        // TODO Auto-generated method stub
        return "Buzz";
    }

}
