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
	
}
