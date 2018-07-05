package com.example.demo;

public class KBTGCondition implements Condition {

    @Override
    public int getIntCheck() {
        // TODO Auto-generated method stub
        return 7;
    }

    @Override
    public boolean check(int input) {
        // TODO Auto-generated method stub
        return input%7==0;
    }

    @Override
    public String say(int input) {
        // TODO Auto-generated method stub
        return "KBTG";
    }

}
