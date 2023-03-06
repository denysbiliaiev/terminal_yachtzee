package dnb.game.yahtzee;

public class FourInARowScore extends Score {

	private final int diceCount = 1;
	private final int fourInARowScore = 20;

	public int evaluate(Die[] dice) {
		int points = 0;
		int onescount = 0;
		int twoscount = 0;
		int threescount = 0;
		int fourscount = 0;

		for (Die die : dice) {
			int value = die.getValue();
			if (value == 1) {
				onescount++;
			}
			if (value == 2) {
				twoscount++;
			}
			if (value == 3) {
				threescount++;
			}
			if (value == 4) {
				fourscount++;
			}
		}

		if (onescount == diceCount && twoscount == diceCount && threescount == diceCount && fourscount == diceCount) {
			points = fourInARowScore;
		}

		return points;
	}

	public String toString() {
		return "Four in a row";
	}

}
