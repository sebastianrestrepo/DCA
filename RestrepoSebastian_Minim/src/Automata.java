import processing.core.PApplet;

public abstract class Automata implements Runnable {

	protected int posX;
	protected int posY;
	protected PApplet app;

	public Automata(PApplet app, int posX, int posY){
		this.app = app;
		this.posX = posX;
		this.posY = posY;
	}

	//GETTERS Y SETTERS
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	
}
