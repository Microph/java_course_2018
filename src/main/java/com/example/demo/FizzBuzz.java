package com.example.demo;

public class FizzBuzz {
	public String test(int input) {
		int[] checkers = {15, 5, 3};
		String[] outputs = {"FizzBuzz", "Buzz", "Fizz"};
		for(int i=0; i<checkers.length; i++) {
			if(input%checkers[i] == 0) {
				return outputs[i];
			}
		}
		
		return String.valueOf(input);
	}
}
