package dnb.game.yahtzee;

public class AnythingScore extends Score {

	public int evaluate(Die[] dice) {
		int points = 0;

		for (int i = 0; i < dice.length; i++) {
			points = points + dice[i].getValue();
		}

		return points;
	}

	public String toString() {
		return "Anything";
	}

	public int evaluateJokerRules(Die[] dice) {
		return evaluate(dice);
	}

}
