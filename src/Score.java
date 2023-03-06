package dnb.game.yahtzee;

public abstract class Score {
	protected boolean isPopulated;
	private int points;

	public abstract int evaluate(Die[] dice);

	public void setScore(Die[] dice) {

		points = evaluate(dice);

		isPopulated = true;
	}

	public boolean isPopulated() {
		return isPopulated;
	}

	public int getPoints() {
		return points;
	}

}