package com.example.demo;

public class CalculatorServer {
	public void add(Calculator calculator, int i, int j) {
		// TODO Auto-generated method stub
		calculator.onSuccess(i + j);
	}

}
