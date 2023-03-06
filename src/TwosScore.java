package dnb.game.yahtzee;

public class TwosScore extends Score {
	@Override
	public int evaluate(Die[] dice) {
		int points = 0;

		for (int i = 0; i < dice.length; i++) {
			if (dice[i].getValue() == 2) {
				points += 2;
			}
		}

		return points;
	}

	public String toString() {
		return "Twos";
	}

}