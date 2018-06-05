package model;

public class Score {
	private static int score;
	public static int getScore() {
		return score;
	}

	public static void setScore() {
		score += 200;	
	}
}
