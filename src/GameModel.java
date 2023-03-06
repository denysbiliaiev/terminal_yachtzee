package dnb.game.yahtzee;

import java.util.Scanner;

public class GameModel {
	public static final int MAX_ROLL = 3;
	public static final int DICE_COUNT = 4;
	
	private Die[] dice = new Die[DICE_COUNT];
	private Player[] players;
	private Scanner scanner;
	private int currentRound = 1;
	
	public GameModel(Scanner scanner) {
		this.scanner = scanner; 
	}
	
	public void run(String[] playersName) {
		setupPlayer(playersName);
		setupDice();
		start();
	}
	
	private void start() {
		while (this.currentRound <= Scorecard.TOTAL_ROUNDS) {
			for (Player player: players) {
				System.out.printf("%s Round: %s %s", Util.ANSI_CYAN, this.currentRound, Util.ANSI_RESET);
				System.out.println();
				
				nextRound(player);
				player.completeRound();
			}
			
			this.currentRound++;
		}
		
		Board.viewGameResult(players);
	}
	
	private void nextRound(Player player) {
		while (player.getRollCount() <= GameModel.MAX_ROLL) {
			System.out.printf(Util.SEPARATOR);
			System.out.printf("Player: %s, Roll number: %s %n", player.getName(), player.getRollCount());
			System.out.printf(Util.SEPARATOR);
			
			if (player.getRollCount() > 1) {
				System.out.println("Enter DICE number(s) to keep (enter separated by a space):");
				
				if (scanner.hasNextLine()) {
					player.setFreezDice(scanner.nextLine());
				}
				scanner.reset();
			}
			
			player.rollDice();
		    
			Board.viewRollResult(player);
		
			if (!player.getIsRoundScorePopulated()) {
				System.out.println("Enter N from Score Table e.g.(1...8) to keep Score or skip (press enter):");
				if (scanner.hasNextLine()) {
					String nextLine = scanner.nextLine();
					if (Util.isNumeric(nextLine) && Integer.parseInt(nextLine) <= Scorecard.TOTAL_ROUNDS) {
						player.populateScore(Integer.parseInt(nextLine));
					}
				}
				scanner.reset();
			    
			    if (player.getRollCount() == 3) {
			    	while (scanner.hasNextLine()) {
						String nextLine = scanner.nextLine();
						if (Util.isNumeric(nextLine) && Integer.parseInt(nextLine) <= Scorecard.TOTAL_ROUNDS) {
							player.populateScore(Integer.parseInt(nextLine));
							return;
						}
					}
		    	}
			    scanner.reset();
			}
			
			player.addRollCount();
		}	
	}
	
	private void setupDice() {
		for (int i = 0; i < DICE_COUNT; i++) {
			dice[i] = new Die();
		}
	}
	
	private void setupPlayer(String[] playersName) {
	    this.players = new Player[playersName.length];
	    
	    for (int i = 0; i < playersName.length; i++) {
    	   	this.players[i] = new Player(new Scorecard(), this.dice).setName(playersName[i]);
		}
	
	}

}
