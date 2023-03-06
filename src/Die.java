package dnb.game.yahtzee;

import java.util.Random;

public class Die {

	private int value;

	public Die() {
		roll();
	}

	public void roll() {
		Random random = new Random();

		int min = 1;
		int max = 5;

		this.value = random.nextInt(max + min) + min;
	}

	public int getValue() {
		return this.value;
	}

}