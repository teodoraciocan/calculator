package main;
import java.util.Scanner;

import controller.Calculator;
import controller.Controller;

public class StartApp {

	private static Controller ctrl = new Controller();
	private static Scanner scan;
	
	public static void main(String[] args){ 
		
		scan = new Scanner(System.in);
		
		while(true){
		
			System.out.println("\n\t\tMENU:"
					+ "\n---------------------------------------------------------\n"
					+ "\t\t1. Solve an already given expression\n"
					+ "\t\t2. Solve an expression given from the keyboard\n"
					+ "\t\t0. Exit\n\n"
					+ "For help how to use the calculator press '?'\n\n"
					+ "Choose an option: ");
			try{
				char op = scan.next().charAt(0);
				
				switch(op){
				
				case '1':
					ctrl.setExpr("( 1 + 1 + ( 2 + 3 ) ) * ( 2 * ( 2 + 1 ) ) + ( 1 * 1 * 2 * ( 1 + 1 ) )");
					
					if(ctrl.verify()) {
						ctrl.calculate();
						System.out.println(ctrl.getResult());;
					}
					else 
						System.out.println("The given expression is not correct!");
					break;
					
				case '2':
					System.out.println("Give an expression(use whitespace between numbers, operators and brackets): ");	
					scan.nextLine();
					ctrl.setExpr(scan.nextLine());
					
					if(ctrl.verify()) {
						ctrl.calculate();
						System.out.println(ctrl.getResult());
					}
					else 
						System.out.println("The given expression is not correct!");
					break;
					
				case '0':
					System.out.println("\n\tThank you for using the program! :D");
					return;
					
				case '?':
					System.out.println("\n\t\tHELP:"
							+ "\n---------------------------------------------------------\n"
							+ "You can give numbers, the brackets ')' and '(' and the operators '+' and '*'.\n"
							+ "All of these characters have to be separated by a whitespace.\n");
					break;
					
				default:
					System.out.println("\tThis option does not exist!\n\tDo you want to continue?(yes/no) ");
					String answer = scan.next();
					
					if(answer.equals("yes")) 
						break;
					else {
						System.out.println("\n\tThank you for using the program! :D");
						return;
					}
				}
			}catch(NumberFormatException ex){
				System.out.println("\n\nYou didn't write something right!\nPlease check if the given sequence you've given is separated with whitespaces!");
			}
		}
	}
}
