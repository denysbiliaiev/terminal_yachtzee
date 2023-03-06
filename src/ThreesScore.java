package dnb.game.yahtzee;

public class ThreesScore extends Score {
	@Override
	public int evaluate(Die[] dice) {
		int points = 0;

		for (int i = 0; i < dice.length; i++) {
			if (dice[i].getValue() == 3) {
				points += 3;
			}
		}

		return points;
	}

	public String toString() {
		return "Threes";
	}

}
