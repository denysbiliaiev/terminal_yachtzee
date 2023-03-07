package dnb.game.yahtzee;

public class GameModel {
	public static final int MAX_ROLL = 3;
	public static final int DICE_COUNT = 4;
	
	private Environment env;
	private String[] options;
	private Die[] dice = new Die[DICE_COUNT];
	private Player[] players;
	private int currentRound = 1;
	
	public GameModel(String[] options) {
		this.options = options;
	}
	
	public void run(Environment env) {
		this.env = env;
		
		setupPlayer();
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
		while (!player.getIsRoundScorePopulated() && player.getRollCount() <= GameModel.MAX_ROLL) {
			System.out.printf(Util.SEPARATOR);
			System.out.printf("Player: %s, Roll number: %s %n", player.getName(), player.getRollCount());
			System.out.printf(Util.SEPARATOR);
			
			if (player.getRollCount() > 1) {
				player.setFreezDice(env.inputString("Enter DICE number(s) to keep or skip (press enter):%n"));
			}
			
			player.rollDice();
		    
			Board.viewRollResult(player);
		
			int scoreType = -1;
			
			if (player.getRollCount() < 3) {
				scoreType = env.intputInteger("Enter N from Score Table e.g.(1...8) to keep Score or skip (press enter):%n");
			} else {
				scoreType = env.intputIntegerRequired("(Required*) Enter N from Score Table e.g.(1...8) to keep Score:%n");
			}	
	
			if (scoreType != -1 && scoreType <= Scorecard.TOTAL_ROUNDS) {
				player.populateScore(scoreType);
			}
			
			player.addRollCount();
		}	
	}
	
	private void setupDice() {
		for (int i = 0; i < DICE_COUNT; i++) {
			dice[i] = new Die();
		}
	}
	
	private void setupPlayer() {
	    this.players = new Player[this.options.length];
	    
	    for (int i = 0; i < this.options.length; i++) {
    	   	this.players[i] = new Player(new Scorecard(), this.dice).setName(this.options[i]);
		}
	
	}

}
