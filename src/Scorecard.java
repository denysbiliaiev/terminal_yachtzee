package dnb.game.yahtzee;

public class Scorecard {
	public static final int TOTAL_ROUNDS = 8;
	public static final int ONES = 0;
	public static final int TWOS = 1;
	public static final int THREES = 2;
	public static final int FOURS = 3;
	public static final int THREE_OF_A_KIND = 4;
	public static final int FOUR_OF_A_KIND = 5;
	public static final int FOUR_IN_A_ROW = 6;
	public static final int ANYTHING = 7;
	
	private Score[] scores;
	
	public Scorecard() {
		scores = new Score[TOTAL_ROUNDS];
		scores[ONES] = new OnesScore();
		scores[TWOS] = new TwosScore();
		scores[THREES] = new ThreesScore();
		scores[FOURS] = new FoursScore();
		scores[THREE_OF_A_KIND] = new ThreeOfAKindScore();
		scores[FOUR_OF_A_KIND] = new FourOfAKindScore();
		scores[FOUR_IN_A_ROW] = new FourInARowScore();
		scores[ANYTHING] = new AnythingScore();
	}

	public int evaluate(Die[] dice, int scoreType) {
		return scores[scoreType].evaluate(dice);
	}
		
	public String getScores(int scoreType) {
		return scores[scoreType].toString();
	}

	public void setScore(Die[] dice, int scoreType){
		scores[scoreType].setScore(dice);	
	}
	
	public int getPoints(int scoreType) {
		return scores[scoreType].getPoints();
	}
	
	public boolean isPopulated(int scoreType) {
		return scores[scoreType].isPopulated();
	}
	
	public int[][] getEvaluations(Die[] dice) {
		int[][] evaluations = new int[TOTAL_ROUNDS][2];
    	
		for (int scoreIndex = 0; scoreIndex < TOTAL_ROUNDS; scoreIndex++) {
    		if (this.isPopulated(scoreIndex)) {
				evaluations[scoreIndex][0] = this.getPoints(scoreIndex);
				evaluations[scoreIndex][1] = 1;
    		} else {
    			evaluations[scoreIndex][0] = this.evaluate(dice, scoreIndex);
    			evaluations[scoreIndex][1] = 0;		
    		}	
    	}
		
		return evaluations;
	}
	
	public int getTotalPoints() {
		int totalPoints = 0;
		
		for (int i = 0; i < TOTAL_ROUNDS; i++) {
			totalPoints += scores[i].getPoints();
		}
		
		return totalPoints;
	}

}
