package main;

import java.util.List;
import java.util.Stack;

public class CalcolatorePostfix {
	private Stack<String> stack = new Stack<>();
	private List<String> elements;
	private int index;
	
	public double calcola(List<String> elements) {
		this.elements = elements;
		
		while(current() != null) {
			String curr = nextElement();
			
			if(curr.chars().allMatch( Character::isDigit )) {
				stack.push(curr);
			}
			
			switch(curr) {
			case "+": {
				String right_s = stack.pop();
				String left_s = stack.pop();
				double right_d = Double.parseDouble(right_s);
				double left_d = Double.parseDouble(left_s);
				
				double result = right_d + left_d;
				String result_s = String.valueOf(result);
				stack.push(result_s);
				
				break;
			}
			case "-": {
				String right_s = stack.pop();
				String left_s = stack.pop();
				double right_d = Double.parseDouble(right_s);
				double left_d = Double.parseDouble(left_s);
				
				double result = right_d - left_d;
				String result_s = String.valueOf(result);
				stack.push(result_s);
				
				break;
			}
			case "*": {
				String right_s = stack.pop();
				String left_s = stack.pop();
				double right_d = Double.parseDouble(right_s);
				double left_d = Double.parseDouble(left_s);
				
				double result = right_d * left_d;
				String result_s = String.valueOf(result);
				stack.push(result_s);
				
				break;
			}
			case "/": {
				String right_s = stack.pop();
				String left_s = stack.pop();
				double right_d = Double.parseDouble(right_s);
				double left_d = Double.parseDouble(left_s);
				
				double result = right_d / left_d;
				String result_s = String.valueOf(result);
				stack.push(result_s);
				
				break;
			}
			}
		}
		
		System.out.println(stack.pop());
		
		return 0;
	}
	
	private String current() {
		if(index < this.elements.size()) {
			String current = this.elements.get(index);
			return current;
		}
		return null;
	}
	
	private String nextElement() {
		if(index < this.elements.size()) {
			String current = this.elements.get(index);
			index++;
			return current;
		}
		return null;
	}
	
	private void advance() {
		index++;
	}
}
