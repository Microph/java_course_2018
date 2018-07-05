package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FizzBuzz {   
    private List<Condition> conditionList;
    
	public String test(int input) {
	    setupConditionList();
		for(Condition condition : conditionList) {
			if(condition.check(input)) {
				return condition.say();
			}
		}
		
		return String.valueOf(input);
	}
	
	public void setupConditionList() {
	    conditionList = new ArrayList<>();
	    conditionList.add(new FizzBuzzCondition());
	    conditionList.add(new FizzCondition());
	    conditionList.add(new BuzzCondition());
	    conditionList.add(new KBTGCondition());
	    
	    Collections.sort(conditionList, new Comparator<Condition>(){
            @Override
            public int compare(Condition c1, Condition c2) {
                return c2.getIntCheck() - c1.getIntCheck();
            }
	        
	    });
	}
}
