package model;

/**
 * <h1>The Class Score.</h1>
 * <p>
 * This Class is used to modify score when he gets a purse.
 * It needed to be in the model but by a dependency problem we placed it here.
 * </p>
 * @author Team12
 * @version final
 */

public class Score {
	
	/**
	 * The attribute score
	 */
	private static int score;
	
	/**
	 * 
	 * @return score
	 */
	public static int getScore() {
		return score;
	}

	/**
	 * This Method is used to add 200 points on the player's score when he gets a purse.
	 */
	public static void setScore() {
		score += 200;	
	}
}
