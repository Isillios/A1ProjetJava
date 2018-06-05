package model.element.mobile;

import model.element.*;
import model.element.motionless.GateOpen;
//import model.element.motionless.OpenedDoor;
//import showboard.IBoard;
import model.*;



public abstract class Mobile extends Element implements IMobile {

	private IMap map;
	private int position;
	private Boolean alive = true;
	//private  IBoard  board;
	private String Objet;
	private static Boolean oui = false;
	
	public Mobile( IMap map,Permeability permeability) {
		super(permeability);
		this.setMap(map);
	}
	
	 Mobile(int position,IMap map, Permeability permeability) {     
		 this( map, permeability);  
		 this.setPosition(position);
	    }
	 
	public void setHasMoved() {
		map.setMobileHasChanged();
		}

	
	public int getPosition() {
		return this.position;
	}
	
	public int setPosition(int position) {
		this.position = position;
		return this.position;
	}

	public Boolean getAlive() {
		return this.alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

/*	protected IBoard getBoard() {
		return this.board;
	}

	public void setBoard(IBoard board) {
		this.board = board;
	}*/
	
	

	public void moveUp(int position,String objet) {
		if (checkNextPosition(position-20,objet)) {
			map.setOnMap((position-20), map.getOnMap(position));
			map.setOnMap(position, 'b');
			setPosition(position-20);
			this.setHasMoved();	
		}			
	}
			
	public void moveDown(int position,String objet) {
		if (checkNextPosition(position+20,objet)) {
			map.setOnMap((position+20), map.getOnMap(position));
			map.setOnMap(position, 'b');
			setPosition(position+20);}
			this.setHasMoved();	
	}
					
	public void moveLeft(int position,String objet) {
		if (checkNextPosition(position-1,objet)) {
			map.setOnMap((position-1), map.getOnMap(position));
			map.setOnMap(position, 'b');
			setPosition(position-1);}
			this.setHasMoved();
	}
			
	
	public void moveRight(int position,String objet) {
		if (checkNextPosition(position+1,objet)) {
			map.setOnMap((position+1), map.getOnMap(position));
			map.setOnMap(position, 'b');;
			setPosition(position+1);}
			this.setHasMoved();
	}
			

	public void moveUpLeft(int position,String objet) {
		if (checkNextPosition(position-21,objet)) {
			map.setOnMap((position-21), map.getOnMap(position));
			map.setOnMap(position, 'b');
			setPosition(position-21);}
			this.setHasMoved();
	}
			
	
	public void moveUpRight(int position,String objet) {
		if (checkNextPosition(position-19,objet)) {
			map.setOnMap((position-19), map.getOnMap(position));
			map.setOnMap(position, 'b');
			setPosition(position-19);}
			this.setHasMoved();
	}

	public void moveDownLeft(int position,String objet) {
		if (checkNextPosition(position+21,objet)) {
			map.setOnMap((position+21), map.getOnMap(position));
			map.setOnMap(position, 'b');
			setPosition(position+21);}
			this.setHasMoved();
	}

	public void moveDownRight(int position,String objet) {
		if (checkNextPosition(position+19,objet)) {
			map.setOnMap((position+19), map.getOnMap(position));
			map.setOnMap(position, 'b');
			setPosition(position+19);}
			this.setHasMoved();
	}

	protected void death() {
		setAlive(false);
        this.setHasMoved();
	}


	public IMap getMap() {
		return this.map;
	}
	
	 
	private void setMap(final IMap map) {  
		this.map = map;  
	}
	public static Boolean getWin() {
		return Mobile.oui;
	}
	
	public void setWin(Boolean oui) {
		Mobile.oui = oui;
	}
	protected void win() {
		setWin(true);
		this.setHasMoved();
	}
	
	
	public boolean checkNextPosition(int nextPosition, String objet) {	
		boolean possible = true;
		
		switch(map.getOnMap(nextPosition)) {
		case 'h' :
			possible = false;
			break;
		case 'v' :
			possible = false;
			break;
		case 'i' :
			possible = false;
			break; 
		case 'g' :
			possible = false;
			break;	
		case 'M' :
				if (objet == "Player") {
					possible = false;
					death();
				}else if(objet == "fireball") {
					possible = true;
				}else {
					possible = false;
				}
				break;
		case 'm' :
			if (objet == "Player") {
				possible = false;
				death();	
			}
			else if(objet == "fireball") {
				possible = true;
			}
			else { 
				possible = false;
			}
			break;
		case 'N' :
			if (objet == "Player") {
				possible = false;
				death();
			}
			else if(objet == "fireball") {
				possible = true;
			}else {
				possible = false;
			}
			break;  
		case 'n' :
			if (objet == "Player") {
				possible = false;
				death();
			}
			else if(objet == "fireball") {
				possible = true;
			}
			else {
				possible = false;
			}
			break; 
		case 'G' :
			if(objet == "Player") {
				possible = false;
				win();
			} 
			else {
				possible = false;
			}
			break;
		case 'c' :
			if(objet == "Player") {
				possible = true;
				GateOpen.GateCtoGateO(map);
			} 
			else {
				possible = false;
			}
		case 'p' :
			if(objet == "Player") {
				possible = true;
				Score.setScore();
			} 
			else {
				possible = false;
			}
			break;
		case 'f' :
			if(objet == "Player") {
				possible = true;
				setMana(true);			} 
			else if (objet == "Demon"){
				map.setOnMap(getPosition(), 'o');
				death();
				setMana(true);
				possible = false;
			}
		case 'b' :
			possible = true;
			break;
		case 'U' :
			if(objet == "Demon") {
				possible = true;
				Demon.kill();
			} 
			else {
				possible = false;	
			}
		}
		return possible;	
	}
	
	public String getObjet() {
		return Objet;
	}
	
	public void setObjet(String objet) {
		Objet = objet;
	}	
}