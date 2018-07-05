package com.example.demo;

public class BaseCondition implements Condition {
    private int input;
    
    @Override
    public int getIntCheck() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public boolean check(int input) {
        // TODO Auto-generated method stub
        this.input = input;
        return true;
    }

    @Override
    public String say() {
        // TODO Auto-generated method stub
        return String.valueOf(this.input);
    }

}
