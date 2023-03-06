package dnb.game.yahtzee;

public class OnesScore extends Score {
	@Override
	public int evaluate(Die[] dice) {
		int points = 0;

		for (int i = 0; i < dice.length; i++) {
			if (dice[i].getValue() == 1) {
				points += 1;
			}
		}

		return points;
	}

	public String toString() {
		return "Ones";
	}

}
