package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Calcolatore {
	
	private Stack<String> stack = new Stack<>();
	private String expression;
	private int index;
	private List<String> elements = new ArrayList<>();
	
	public double calcola(String expression) {
		this.expression = expression;
		
		while(current() != '\0'){
			char curr = nextChar();
			
			if(Character.isWhitespace(curr)) {
				continue;
			}
			
			if(curr == '(') {
				continue;
			}
			if(curr == ')') {
				String elem = stack.pop();
				this.elements.add(elem);
			}
			
			if(Character.isDigit(curr)) {
				int start = index-1;
				while(Character.isDigit(current())) {
					advance();
				}
				
				String text = this.expression.substring(start, index);
				
				this.elements.add(text);
			}
			
			switch(curr) {
			case '+':
				stack.push("+");
				break;
			case '-':
				stack.push("-");
				break;
			case '*':
				stack.push("*");
				break;
			case '/':
				stack.push("/");
				break;
			}
		}
		
		CalcolatorePostfix calcolatorePostfix = new CalcolatorePostfix();
		double result = calcolatorePostfix.calcola(this.elements);
		return result;
	}
	
	private char current() {
		if(index < expression.length()) {
			char current = expression.charAt(index);
			return current;
		}
		return '\0';
	}
	
	private char nextChar() {
		if(index < expression.length()) {
			char current = expression.charAt(index);
			index++;
			return current;
		}
		return '\0';
	}
	
	private void advance() {
		index++;
	}
}
