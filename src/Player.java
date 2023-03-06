package dnb.game.yahtzee;

public class Player {
	private String name;
	private Scorecard scorecard;
	private Die[] dice;
	private String freezDice = "";
	private int rollCount = 1;
	private boolean isRoundScorePopulated = false;

	public Player(Scorecard scoreCard, Die[] dice) {
		this.scorecard = scoreCard;
		this.dice = dice;
	}

	public void rollDice() {
		if (freezDice.isEmpty()) {
			this.rollAllDice();
		} else {
			for (int i = 0; i < 4; i++) {
				if (!this.freezDice.contains(String.valueOf(i + 1))) {
					this.rollADie(i + 1);
				}
			}
		}
	}

	public void rollAllDice() {
		for (int i = 0; i < this.dice.length; i++) {
			this.dice[i].roll();
		}
	}

	public void rollADie(int diceNum) {
		this.dice[diceNum - 1].roll();
	}

	public void populateScore(int scoreType) {
		this.setScore(scoreType);
	}

	public void putDiceAside() {

	}

	public void setScore(int scoreType) {
		if (rollCount >= 1 && !this.scorecard.isPopulated(scoreType)) {
			this.scorecard.setScore(dice, scoreType);
			this.isRoundScorePopulated = true;
		}
	}

	public boolean getIsRoundScorePopulated() {
		return this.isRoundScorePopulated;
	}

	public void completeRound() {
		this.rollCount = 1;
		this.isRoundScorePopulated = false;
	}

	public String getName() {
		return this.name;
	}

	public Player setName(String name) {
		this.name = name;

		return this;
	}

	public int getRollCount() {
		return this.rollCount;
	}
	
	public void addRollCount() {
		this.rollCount++;
	}

	public Die[] getDice() {
		return this.dice;
	}

	public Scorecard getScorecard() {
		return this.scorecard;
	}

	public String getFreezDice() {
		return this.freezDice;
	}

	public void setFreezDice(String freezDice) {
		this.freezDice = freezDice;
	}

}
