package com.example.demo;

public class FizzCondition implements Condition {

    @Override
    public int getIntCheck() {
        // TODO Auto-generated method stub
        return 3;
    }

    @Override
    public boolean check(int input) {
        // TODO Auto-generated method stub
        return input%3==0;
    }

    @Override
    public String say() {
        // TODO Auto-generated method stub
        return "Fizz";
    }

}
