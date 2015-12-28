package main.java.ru.lessons.lesson;

import java.util.Scanner;
/**
 * Class Console Input
 * We implemented from Input
 * and added new methods for input
 * @author Elektron
 *
 */
public class ConsoleInput implements Input{
	
	private final Scanner scanner;
	
	/*
	 * @param scanner
	 * for input numbers
	 */
	public ConsoleInput(Scanner scanner) {
		this.scanner = scanner;
	}

	/*
	 * method for input string variables
	 * @see main.java.ru.lessons.lesson.Input#next()
	 * @param index
	 */
	@Override
	public String next() {
		return this.scanner.next();
	}
	
	/*
	 * close after exit program
	 * @see main.java.ru.lessons.lesson.Input#close()
	 */
	@Override
	public void close() {
		this.scanner.close();
	}
}
