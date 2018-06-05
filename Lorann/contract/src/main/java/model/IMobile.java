package model;


public interface IMobile extends IElement {
	Boolean isAlive();
	Boolean setAlive();
	int getPosition();
	void move(int move);
	void stop();
	void setMana(boolean b);
	boolean getMana();
	Boolean getWin();
	void setWin();
}