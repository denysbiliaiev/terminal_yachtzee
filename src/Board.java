package dnb.game.yahtzee;

public class Board {
	
	public static void viewRollResult(Player player) {
		viewDice(player);
		viewScore(player);
	}
	
	public static void viewGameResult(Player[] players) {
		String winnerName = "";
		int[] totalScoreByPlayer = new int[players.length];
		int maxTotalScore = 0;
		
		for (int i = 0; i < players.length; i++) {
			int totalScore = players[i].getScorecard().getTotalPoints();
			
			totalScoreByPlayer[i] = totalScore;
			
			if (totalScore > maxTotalScore) {
				maxTotalScore = totalScore;
				winnerName = players[i].getName();
			}
			
			viewPlayerResults(players[i], totalScore);
		}
		
		System.out.printf("%s Player: %s, Total Score: %s Winner!!! %s", Util.ANSI_GREEN, winnerName, maxTotalScore, Util.ANSI_RESET);
	}

	private static void viewDice(Player player) {
		System.out.printf("DICE:");
		for (int i = 0; i < player.getDice().length; i++) {
			String color = player.getFreezDice().contains(String.valueOf(i + 1)) ? Util.ANSI_RED : Util.ANSI_GREEN;
			System.out.printf("%s %3d %s", color, i + 1, Util.ANSI_RESET);
		}
		System.out.println();
		System.out.printf("FACE:");
		for (int i = 0; i < player.getDice().length; i++) {
			System.out.printf("%s %3d %s", "", player.getDice()[i].getValue(), "");
		}
		System.out.println();
	}

	private static void viewScore(Player player) {
		int[][] evaluations = player.getScorecard().getEvaluations(player.getDice());
		System.out.printf(Util.SEPARATOR);
		System.out.printf("| %-1s | %-16s | %-6s |%n", "N", "ROLLS", "POINTS");
		System.out.printf(Util.SEPARATOR);

		for (int i = 0; i < evaluations.length; i++) {
			int[] evaluationByCategory = evaluations[i];
			String scoreName = player.getScorecard().getScores(i);
			String color = evaluationByCategory[1] == 0 ? Util.ANSI_GREEN : Util.ANSI_RED;
			String scoreTypeColor = color + i + Util.ANSI_RESET;

			System.out.printf("| %-3s | %-16s | %-6s |%n", scoreTypeColor, scoreName,
					String.valueOf(evaluationByCategory[0]));

			System.out.printf(Util.SEPARATOR);
		}
	}
	
	private static void viewPlayerResults(Player player, int totalScore) {
		int[][] evaluations = player.getScorecard().getEvaluations(player.getDice());
		System.out.printf(Util.SEPARATOR);
		System.out.printf("%s Games result for Player: %s %s %n", Util.ANSI_RED, player.getName(), Util.ANSI_RESET);
		System.out.printf(Util.SEPARATOR);
		System.out.printf(Util.SEPARATOR);
		System.out.printf("| %-20s | %-6s |%n", "ROLLS", "POINTS");
		System.out.printf(Util.SEPARATOR);

		for (int i = 0; i < evaluations.length; i++) {
			int[] evaluationByCategory = evaluations[i];
			String scoreName = player.getScorecard().getScores(i);
			System.out.printf("| %-20s | %-6s |%n", scoreName, String.valueOf(evaluationByCategory[0]));
			System.out.printf(Util.SEPARATOR);
		}
		System.out.printf(Util.SEPARATOR);
		System.out.printf("| %-20s | %-6s |%n", "TOTAL SCORE", totalScore);
		System.out.printf(Util.SEPARATOR);
	}
	
}
