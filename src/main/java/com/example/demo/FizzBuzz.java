package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FizzBuzz {   
    private List<FizzBuzzCondition> conditionList;
    
	public String test(int input) {
	    setupConditionList();
		for(FizzBuzzCondition condition : conditionList) {
			if(input%condition.getIntCheck() == 0) {
				return condition.getPairedOutput();
			}
		}
		
		return String.valueOf(input);
	}
	
	public void setupConditionList() {
	    conditionList = new ArrayList<>();
	    conditionList.add(new FizzBuzzCondition(15, "FizzBuzz"));
	    conditionList.add(new FizzBuzzCondition(3, "Fizz"));
	    conditionList.add(new FizzBuzzCondition(5, "Buzz"));
	    conditionList.add(new FizzBuzzCondition(7, "KBTG"));
	    
	    Collections.sort(conditionList, new Comparator<FizzBuzzCondition>(){
            @Override
            public int compare(FizzBuzzCondition c1, FizzBuzzCondition c2) {
                return c2.getIntCheck() - c1.getIntCheck();
            }
	        
	    });
	}
}
