package controller;

import java.util.ArrayList;
import java.util.List;

public class Controller implements Calculator {
	
	private String expr;
	private int result;
	

	public Controller(String expr){
		this.expr = expr;
	}
	
	public Controller(){
		
	}
	
	/*
	 * converts the string[] s in a string 
	 */
	
	public String toString(String[] s){
		String newString = "";
		for(int i = 0; i < s.length; i++){
			newString = newString + " " + s[i];
		}
		return newString;
	}
	
	
	/*
	 * return the index of the searched char in a string
	 */
	
	public int find (String s, char c){
		int index = 0;
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == c){
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	/*
	 * calcualte the result from the + sequence
	 */
	
	public int plus(String s1, String s2){
		
		int rez = 0;
		rez = Integer.parseInt(s1) + Integer.parseInt(s2);
		return rez;
	}
	
	/*
	 * calcualte the result from the * sequence
	 */
	public int multiplication(String s1, String s2){
		
		int rez = 0;
		rez = Integer.parseInt(s1) * Integer.parseInt(s2);
		return rez;
	}
		
	
	
	/*
	 * caculates the rez from the brackets
	 */
	
	public int bracketsRez(String s1){
		int rez = 0;
		String[] s = s1.split(" ");
		
		
		List<String> stringArray = new ArrayList<String>();
		for (int i = 0; i < s.length; ++i){
			stringArray.add(s[i]);
		}
		
		
		for (int i =0; i < stringArray.size();i++){
			if (stringArray.get(i) == ")"){
				stringArray.remove(i);
				break;
			}
				
		}
		
			
		
		while (s1.contains("*")){
			
			for (int i = 0; i < stringArray.size(); i++){
				if (stringArray.get(i).equals("*")){
					rez = multiplication(stringArray.get(i-1), stringArray.get(i+1));
					stringArray.remove(i-1);
					i = i-1;
					stringArray.remove(i+1);
					stringArray.set(i, Integer.toString(rez));
					//put all the elements in aux
					String aux = "";
					for (int j = 0; j < stringArray.size(); ++j){
						aux = aux + stringArray.get(j);
					}
					s1 = aux;
					
				}
			}
		}
		
		while (s1.contains("+")){
			
			for (int i = 0; i < stringArray.size(); i++){
				if (stringArray.get(i).equals("+")){
					rez = plus(stringArray.get(i-1), stringArray.get(i+1));
					stringArray.remove(i-1);
					i = i-1;
					stringArray.remove(i+1);
					stringArray.set(i, Integer.toString(rez));
					//put all the elements in aux
					String aux = "";
					for (int j = 0; j < stringArray.size(); ++j){
						aux = aux + stringArray.get(j);
					}
					s1 = aux;
					
				}
			}
		}		
		
		return rez;
	}
	

	
	/*
	 *verify if the expression is correct 
	 */
	
	//@Override
	public boolean verify(){
		
		String newStr = expr;
		newStr = newStr.replaceAll("\\s+",""); //removes all the whitespace
		
		if(expr.charAt(0) == ' ') 
			newStr = ' ' + newStr;
	
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < newStr.length(); i++)
			if ((newStr.charAt(i) == '+' && newStr.charAt(i+1) == '*') || (newStr.charAt(i) == '*' && newStr.charAt(i+1) == '+') 
				||(newStr.charAt(i) == '+' && newStr.charAt(i+1) == '+') || (newStr.charAt(i) == '*' && newStr.charAt(i+1) == '*'))
			//	||(newStr.charAt(i) == ')' && (newStr.charAt(i-1) == '*' || newStr.charAt(i-1) == '+' || newStr.charAt(i-1) == '(')))
			//	||(newStr.charAt(i) == '(' && (newStr.charAt(i-1) != '*'&& newStr.charAt(i-1) != '+' && newStr.charAt(i-1) != ')' && newStr.charAt(i-1) != ' ')
			//	||!(newStr.matches("^[0-9_+*() ]+$"))))
					
						return false;
			
			//verify if the number of the two brackets are equal
			
		for( int j=0; j<newStr.length(); j++ )
			    if (newStr.charAt(j) == '(' ) 
			        count1++;
			    else if (newStr.charAt(j) == ')' ) 
			    			count2++;
		if (count1 != count2) 
			return false;
			
		return true;
	}
	
	/*
	 * calculates the expression
	 */
	
	
	public String calculate(){
		
		List<String> stringArray = new ArrayList<String>();  
		
		
		while (expr.contains(")")){
		
			int index1 = 0;
			int index2 = 0;
			
			index1 = expr.lastIndexOf('(');
			
			for (int i = index1; i < expr.length(); ++i){
				if (expr.charAt(i) == ')'){
					index2 = i;
					break;
				}
			}
			
			
			result = bracketsRez(expr.substring(index1 + 2, index2 - 1));
			
			expr = expr.replace(expr.substring(index1, index2 +1), Integer.toString(result));
			
		}
		
		String[] s = expr.split(" ");
		
		for (String el: s){
			stringArray.add(el);
		}
			
		while (expr.contains("*")){
			
			for (int i = 0; i < stringArray.size(); i++){
				if (stringArray.get(i).equals("*")){
					result = multiplication(stringArray.get(i-1), stringArray.get(i+1));
					stringArray.remove(i-1);
					i = i-1;
					stringArray.remove(i+1);
					stringArray.set(i, Integer.toString(result));
					//put all the elements in aux
					String aux = "";
					for (int j = 0; j < stringArray.size(); ++j){
						aux = aux + stringArray.get(j);
					}
					expr = aux;				
				}
			}
		}
		
		while (expr.contains("+")){
			
			for (int i = 0; i < stringArray.size(); i++){
				if (stringArray.get(i).equals("+")){
					result = plus(stringArray.get(i-1), stringArray.get(i+1));
					stringArray.remove(i-1);
					i = i-1;
					stringArray.remove(i+1);
					stringArray.set(i, Integer.toString(result));
					//put all the elements in aux
					String aux = "";
					for (int j = 0; j < stringArray.size(); ++j){
						aux = aux + stringArray.get(j);
					}
					expr = aux;
				
				}
			}
		}
		
	return Integer.toString(result);
		
		
		
	}
	
	
	
	/*
	 * getters and setters
	 */
	
	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}


		
	

}
