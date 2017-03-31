import processing.core.PApplet;

public class Obstaculo {

	private int posX, posY, tamX, tamY;
	
	public Obstaculo(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		app.rectMode(app.CENTER);
		app.fill(59, 10, 13);
		app.rect(posX, posY, 20, 40);
	}
	
}
