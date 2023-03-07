package dnb.game.yahtzee;

public class Game {

	public static void main(String[] args) {
		Environment env = new Environment();

		try {
			env.run(new GameModel(args));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			env.close();
		}
	}

}