package main.java.ru.lessons.lesson;

import java.rmi.server.Operation;
import java.util.Scanner;

import org.omg.CORBA.UserException;

/**
 * Interact. Calculator
 * General describe about class (....)
 * @author Elektron
 *
 */

public class InteractRunner{
	
	/**
	 * User Input Interface
	 */
	private final Input scan;
	
	private final Calculator calculator;
	
	/*
	 * method Interact Runner
	 * 
	 */
	public InteractRunner(Calculator calculator, Input scan){
		this.scan = scan;
		this.calculator = calculator;
	}
	
	
	/*
	 * method calculation
	 */
	public void calculation(){
		Scanner reader = new Scanner(System.in);
		try{
			Calculator calc = new Calculator();
			double firstDouble = 0;
			double secondDouble = 0;
			String first;
			String second;
			String exit = "no";
			String clearresult="no";
			String operation;
			while(!exit.equals("yes")){
				System.out.println("Input first argument: ");
				first = reader.next();
				firstDouble = Double.valueOf(first);
				System.out.println("Input second ardument: ");
				second = reader.next();
				secondDouble = Double.valueOf(second);
				System.out.println("Input operation: / * - + ");
				operation = reader.next();
				switch(operation){
				case "+":
					calc.add(firstDouble, secondDouble);
					break;
					
				case "-":
					calc.subtract(firstDouble, secondDouble);
					break;
				case "/":
					calc.div(firstDouble, secondDouble);
					break;
				case "*":
					calc.multiply(firstDouble, secondDouble);
					break;
				}
				System.out.println(calc.getResult());
				System.out.println("Save result or not? ");
				clearresult = reader.next();
				if(clearresult.equals("no"))
					calc.clearResult();
				System.out.println("Quit: yes or not");
				exit = reader.next();
			}
		}finally{
			reader.close();
		}
	}
	
	public static void main(String[] args) {
		InteractRunner run = new InteractRunner(new Calculator(), new ConsoleInput(new Scanner(System.in)));
		run.calculation();
	}
	
}