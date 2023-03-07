package dnb.game.yahtzee;

import java.util.Scanner;

public class Environment {
	Scanner scanner;
	
	public void run(GameModel gameModel) {
		try {
			scanner = new Scanner(System.in);
			gameModel.run(this);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			scanner.close();
		} 		
	}  
	
	public void close() {
		scanner.close();
	} 
	
	public String inputString(String label) {
		String input = null;
		
		System.out.printf(label);
		
		if (scanner.hasNextLine()) {
			input = scanner.nextLine();
		}
		
		scanner.reset();
		
		return input;
	}  
	
	public int intputInteger(String label) {
		int input = -1;
		
		System.out.printf(label);
		
		if (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			
			if (Util.isNumeric(nextLine)) {
				input = Integer.parseInt(nextLine);
			}
		}
		
		scanner.reset();
	    
		return input;
	}  
	
	public int intputIntegerRequired(String label) {
		System.out.printf(label);
		
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			
			if (Util.isNumeric(nextLine)) {
				scanner.reset();
				
				return Integer.parseInt(nextLine);
			}
		}
		
		return -1;
	}  
}
