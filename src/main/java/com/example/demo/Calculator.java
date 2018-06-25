package com.example.demo;

interface OnAddListener{
	public void onSuccess(int result);
}

public class Calculator implements OnAddListener{
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.start();
	}
	
	private void start() {
		CalculatorServer main = new CalculatorServer();
		main.add(this, 1, 2);
	}

	@Override
	public void onSuccess(int result) {
		// TODO Auto-generated method stub
		System.out.println("result: " + result);
	}
}
