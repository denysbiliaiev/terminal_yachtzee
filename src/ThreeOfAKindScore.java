package dnb.game.yahtzee;

public class ThreeOfAKindScore extends Score {
	private final int diceCount = 3;

	@Override
	public int evaluate(Die[] dice) {
		int points = 0;
		int onescount = 0;
		int twoscount = 0;
		int threescount = 0;
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
		}

		if (onescount >= diceCount || twoscount >= diceCount || threescount >= diceCount) {
			for (Die die : dice) {
				points = points + die.getValue();
			}
		}

		return points;
	}

	public String toString() {
		return "Three of a kind";
	}

}
