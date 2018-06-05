package model;

public class Score {

	private static int score = 0;
	public static int getScore() {
		return score;
	}

	public static void setScore() {
		score += 200;	
	}

}