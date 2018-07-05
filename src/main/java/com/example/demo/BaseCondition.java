package com.example.demo;

public class BaseCondition implements Condition {
    @Override
    public int getIntCheck() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public boolean check(int input) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String say(int input) {
        // TODO Auto-generated method stub
        return String.valueOf(input);
    }

}
