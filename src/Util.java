package dnb.game.yahtzee;

public class Util {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String SEPARATOR = "---------------------------------%n";
	
	public static boolean isNumeric(String string) {
	    if(string == null || string.equals("")) {
	        return false;
	    }
	    
	    try {
	        int intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	        System.out.println("Input string cannot be parsed to int.");
	    }
	    return false;
	}
}
