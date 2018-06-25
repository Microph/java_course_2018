package com.example.demo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFizzBuzz {
	@Test
	public void test1(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("1", fizzBuzz.test(1));  
	}
	
	@Test
	public void test2(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("2", fizzBuzz.test(2));  
	}
	
	@Test
	public void test3(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("Fizz", fizzBuzz.test(3));  
	}
	
	@Test
	public void test4(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("4", fizzBuzz.test(4));  
	}
	
	@Test
	public void test5(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("Buzz", fizzBuzz.test(5));  
	}
	
	@Test
	public void test6(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("Fizz", fizzBuzz.test(6));  
	}
	
	@Test
	public void test7(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("7", fizzBuzz.test(7));  
	}
	
	@Test
	public void test8(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("8", fizzBuzz.test(8));  
	}
	
	@Test
	public void test9(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("Fizz", fizzBuzz.test(9));  
	}
	
	@Test
	public void test10(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("Buzz", fizzBuzz.test(10));  
	}
	
	@Test
	public void test15(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		assertEquals("FizzBuzz", fizzBuzz.test(15));  
	}
}
