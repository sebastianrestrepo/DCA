import processing.core.PApplet;

public class Obstaculo {

	private int posX, posY, tamX, tamY;
	
	public Obstaculo(int posX, int posY, int tamX, int tamY){
		this.posX = posX;
		this.posY = posY;
		this.tamX = tamX;
		this.tamY = tamY;
	}
	
	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		app.fill(59, 10, 13);
		app.rect(posX, posY, tamX, tamY);
	}
	
}
