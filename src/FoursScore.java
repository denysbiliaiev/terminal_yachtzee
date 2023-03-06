package dnb.game.yahtzee;

public class FoursScore extends Score {

	@Override
	public int evaluate(Die[] dice) {
		int points = 0;

		for (int i = 0; i < dice.length; i++) {
			if (dice[i].getValue() == 4) {
				points += 4;
			}
		}

		return points;
	}

	public String toString() {
		return "Fours";
	}

}
